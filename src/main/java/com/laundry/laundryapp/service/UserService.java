package com.laundry.laundryapp.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.laundry.laundryapp.model.UserLoginModel;
import com.laundry.laundryapp.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.laundry.laundryapp.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<String> addUser(User user) throws ExecutionException, InterruptedException {
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> query = db.collection("users")
                .document(user.getEmail()).set(user);
        List<String> response = new ArrayList<>();
        response.add("User added");
        response.add(query.get().getUpdateTime().toString());
        return response;
    }

    public Object loginUser(UserLoginModel userLoginModel) throws ExecutionException, InterruptedException {
        List<String>userInfo = new ArrayList<>();

        String contact = userLoginModel.getEmail();
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection("users").document(contact);
        ApiFuture<DocumentSnapshot> query = documentReference.get();
        DocumentSnapshot document = query.get();
        if(document.exists()){
            User userData =  document.toObject(User.class);
            if(passwordEncoder.matches(userLoginModel.getPassword(),userData.getPassword())){
                userInfo.add("Authentication passed");
                userInfo.add(userData.getEmail());
                return userInfo;
            }else{
                return  "Authentication failed";
            }
        }
        else {
            return ("No record found");
        }
    }

    public Object getUser(String user_id) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection("users").document(user_id);
        ApiFuture<DocumentSnapshot> query = documentReference.get();
        DocumentSnapshot document = query.get();
        if(document.exists()){
            return document.toObject(UserResponse.class);
        }
        else {
            return ("No record found");
        }
    }
}
