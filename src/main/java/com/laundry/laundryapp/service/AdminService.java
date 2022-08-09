package com.laundry.laundryapp.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.laundry.laundryapp.model.Admin;
import com.laundry.laundryapp.model.AdminLoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class AdminService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<String> addAdminUser(Admin admin)  {
        try {
            String encodedPass = passwordEncoder.encode(admin.getAdminPassword());
            admin.setAdminPassword(encodedPass);
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture<WriteResult> query = db.collection("admin")
                    .document(admin.getAdminUserEmail()).set(admin);
            List<String> response = new ArrayList<>();
            response.add("User added");
            response.add(query.get().getUpdateTime().toString());
            return response;
        }catch (Exception exception){
            System.out.println("Fields are empty");
        }
        return  null;
    }

    public Object loginAdmin(AdminLoginModel adminLoginModel) throws ExecutionException, InterruptedException {
        List<Admin> adminInfo = new ArrayList<>();

        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection("admin").document(adminLoginModel.getEmail());
        ApiFuture<DocumentSnapshot> query = documentReference.get();
        DocumentSnapshot document = query.get();
        if(document.exists()){
            Admin adminData =  document.toObject(Admin.class);
            if(passwordEncoder.matches(adminLoginModel.getPassword() ,adminData.getAdminPassword())){
                adminInfo.add(new Admin(adminData.getAdminUserName(),adminData.getAdminUserEmail(), adminData.getAdminPassword(),adminData.getContact(), adminData.isAdmin()));
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
        List<Admin> response = new ArrayList<>();
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = db.collection("admin").get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot data : documents){
            response.add(data.toObject(Admin.class));
        }
        return response;
    }

    public  List updateAdminInfo(Admin admin ) throws ExecutionException, InterruptedException, IllegalAccessException {
        String email = admin.getAdminUserEmail();
        Firestore db = FirestoreClient.getFirestore();
        HashMap<String, Object> update = new HashMap<>();
        DocumentReference documentReference = db.collection("admin").document(email);

        Field[] fields = Admin.class.getDeclaredFields();
        for( int i = 0; i < fields.length; i++){
            Object value = fields[i].get(admin);
            update.put(fields[i].getName(), value);
        }
        ApiFuture<WriteResult> resultApiFuture = documentReference.set(update, SetOptions.merge());
        List<String> response = new ArrayList<>();
        response.add("User data updated");
        response.add(resultApiFuture.get().getUpdateTime().toString());
        return response;
    }
    public List deleteAdmin(String email) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> query = db.collection("admin")
                .document(email)
                .delete();
        List<String> response = new ArrayList<>();
        response.add("User deleted");
        response.add(query.get().getUpdateTime().toString());
        return response;
    }
}
