package com.laundry.laundryapp.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.laundry.laundryapp.model.OrderBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class OrderService {

    public List getOrders() throws ExecutionException, InterruptedException {
        List<OrderBook> response = new ArrayList<>();
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<QuerySnapshot> query = db.collection("orders").get();
            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
           for (QueryDocumentSnapshot data : documents){
               response.add(data.toObject(OrderBook.class));
           }
        return response;
    }


    public Object getOrder(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection("orders").document(email);
        ApiFuture<DocumentSnapshot> query = documentReference.get();
        DocumentSnapshot document = query.get();
        if(document.exists()){
           return document.toObject(OrderBook.class);
        }
        else {
            return ("No record found");
        }
    }

    public List addOrders (OrderBook orderBook) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> query = db.collection("orders")
                .document(orderBook.getEmail()).set(orderBook);
        List<String> response = new ArrayList<>();
        response.add("Order booked");
        response.add(query.get().getUpdateTime().toString());
        return response;
    }


    public List deleteOrder(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> query = db.collection("orders")
                .document(email)
                .delete();
        List<String> response = new ArrayList<>();
        response.add("Order booked");
        response.add(query.get().getUpdateTime().toString());
        return response;
    }
}
