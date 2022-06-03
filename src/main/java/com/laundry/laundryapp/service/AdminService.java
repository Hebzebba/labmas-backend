package com.laundry.laundryapp.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.laundry.laundryapp.model.Admin;
import com.laundry.laundryapp.model.AdminLoginModel;
import com.laundry.laundryapp.response.AdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class AdminService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<String> addAdminUser(Admin admin) throws ExecutionException, InterruptedException {
        String encodedPass = passwordEncoder.encode(admin.getAdminPassword());
        admin.setAdminPassword(encodedPass);
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> query = db.collection("admin")
                .document(admin.getAdminUserEmail()).set(admin);
        List<String> response = new ArrayList<>();
        response.add("User added");
        response.add(query.get().getUpdateTime().toString());
        return response;
    }

    public Object loginAdmin(AdminLoginModel adminLoginModel) throws ExecutionException, InterruptedException {
        List<AdminResponse> adminInfo = new ArrayList<>();

        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection("admin").document(adminLoginModel.getEmail());
        ApiFuture<DocumentSnapshot> query = documentReference.get();
        DocumentSnapshot document = query.get();
        if(document.exists()){
            Admin adminData =  document.toObject(Admin.class);
            if(passwordEncoder.matches(adminLoginModel.getPassword() ,adminData.getAdminPassword())){
                adminInfo.add(new AdminResponse(adminData.getAdminUser(), adminData.getAdminUserName(),adminData.getAdminUserEmail()));
                return adminInfo;
            }else{
                return  "Authentication failed";
            }
        }
        else {
            return ("No record found");
        }
    }

//    public Object getUser(String user_id) throws ExecutionException, InterruptedException {
//        Firestore db = FirestoreClient.getFirestore();
//        DocumentReference documentReference = db.collection("users").document(user_id);
//        ApiFuture<DocumentSnapshot> query = documentReference.get();
//        DocumentSnapshot document = query.get();
//        if(document.exists()){
//            return document.toObject(UserResponse.class);
//        }
//        else {
//            return ("No record found");
//        }
//    }
}
