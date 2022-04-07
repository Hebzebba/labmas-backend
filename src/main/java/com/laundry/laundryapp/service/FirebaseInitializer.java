package com.laundry.laundryapp.service;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStream;


@Service
public class FirebaseInitializer {
    @Autowired
    ResourceLoader resourceLoader;

    @PostConstruct
    public void initializer(){
       try {
           Resource resource = resourceLoader.getResource("classpath:FirebaseConfig.json");
           InputStream serviceAccount = resource.getInputStream();

//           FileInputStream serviceAccount = new FileInputStream("src/main/resources/FirebaseConfig.json");
           FirebaseOptions options = new FirebaseOptions.Builder()
                   .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                   .build();
           FirebaseApp.initializeApp(options);
       }catch (Exception exception){

           exception.printStackTrace();
       }

    }

}
