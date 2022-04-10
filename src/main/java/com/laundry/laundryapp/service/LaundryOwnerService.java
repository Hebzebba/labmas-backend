package com.laundry.laundryapp.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.laundry.laundryapp.model.LaundryOwners;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class LaundryOwnerService {

    public List getOwners() throws ExecutionException, InterruptedException {
        List<LaundryOwners> response = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = db.collection("laundryOwners").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot data : documents){
            response.add(data.toObject(LaundryOwners.class));
        }
        return response;
    }


    public Object getOwner(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection("laundryOwners").document(email);
        ApiFuture<DocumentSnapshot> query = documentReference.get();
        DocumentSnapshot document = query.get();
        if(document.exists()){
            return document.toObject(LaundryOwners.class);
        }
        else {
            return ("No record found");
        }
    }

    public List addOwner (LaundryOwners laundryOwners) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> query = db.collection("laundryOwners")
                .document(laundryOwners.getEmail()).set(laundryOwners);
        List<String> response = new ArrayList<>();
        response.add("User Registered");
        response.add(query.get().getUpdateTime().toString());
        return response;
    }


    public List deleteOwner(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> query = db.collection("laundryOwners")
                .document(email)
                .delete();
        List<String> response = new ArrayList<>();
        response.add("User deleted");
        response.add(query.get().getUpdateTime().toString());
        return response;
    }
}
