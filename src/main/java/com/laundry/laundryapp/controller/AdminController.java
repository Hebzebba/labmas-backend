package com.laundry.laundryapp.controller;

import com.laundry.laundryapp.model.Admin;
import com.laundry.laundryapp.model.AdminLoginModel;
import com.laundry.laundryapp.model.LaundryDataToUpdate;
import com.laundry.laundryapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin-login")
    public Object adminLogin(@RequestBody AdminLoginModel adminLoginModel) throws ExecutionException, InterruptedException {
        return adminService.loginAdmin(adminLoginModel);
    }

    @PostMapping("/admin-add")
    public List addAdminUser(@RequestBody Admin admin){
        return  adminService.addAdminUser(admin);
    }

    @GetMapping("/admin-all")
    public  List getAdmins () throws ExecutionException, InterruptedException {
        return adminService.getAdmins();
    }

    @PutMapping("/admin/update")
    public List updateLaundryOwnerData (@RequestBody Admin admin) throws ExecutionException, InterruptedException, IllegalAccessException {
        return  adminService.updateAdminInfo(admin);
    }

    @DeleteMapping("/admin/delete")
    public List deleteOrder(@RequestParam String email) throws ExecutionException, InterruptedException {
        return adminService.deleteAdmin(email);
    }
}
