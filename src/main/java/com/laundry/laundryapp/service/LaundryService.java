package com.laundry.laundryapp.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.laundry.laundryapp.model.Laundry;
import com.laundry.laundryapp.response.LaundryDataResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class LaundryService {

    public List getOwners() throws ExecutionException, InterruptedException {
        List<Laundry> response = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = db.collection("laundry").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot data : documents){
            response.add(data.toObject(Laundry.class));
        }
        return response;
    }


    public Object getOwner(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection("laundry").document(email);
        ApiFuture<DocumentSnapshot> query = documentReference.get();
        DocumentSnapshot document = query.get();
        if(document.exists()){
            return document.toObject(Laundry.class);
        }
        else {
            return ("No record found");
        }
    }

    public List addOwner (Laundry laundry) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> query = db.collection("laundry")
                .document(laundry.getEmail()).set(laundry);
        List<String> response = new ArrayList<>();
        response.add("User Registered");
        response.add(query.get().getUpdateTime().toString());
        return response;
    }


    public List deleteOwner(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> query = db.collection("laundry")
                .document(email)
                .delete();
        List<String> response = new ArrayList<>();
        response.add("User deleted");
        response.add(query.get().getUpdateTime().toString());
        return response;
    }

    public List getLaundryData() throws ExecutionException, InterruptedException {
        List<LaundryDataResponse> response = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = db.collection("laundry").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot data : documents){
            response.add(data.toObject(LaundryDataResponse.class));
        }
        return response;
    }
}
