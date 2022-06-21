package com.laundry.laundryapp.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.laundry.laundryapp.model.Admin;
import com.laundry.laundryapp.model.AdminLoginModel;
import com.laundry.laundryapp.model.Laundry;
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
                adminInfo.add(new AdminResponse(adminData.getAdminUserName(),adminData.getAdminUserEmail(), adminData.getContact()));
                return adminInfo;
            }else{
                return  "Authentication failed";
            }
        }
        else {
            return ("No record found");
        }
    }

    public List getAdmins() throws ExecutionException, InterruptedException {
        List<AdminResponse> response = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = db.collection("admin").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot data : documents){
            response.add(data.toObject(AdminResponse.class));
        }
        return response;
    }
}
