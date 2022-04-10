package com.laundry.laundryapp.controller;

import com.laundry.laundryapp.model.LaundryOwners;
import com.laundry.laundryapp.service.LaundryOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LaundryOwnerController {

    @Autowired
    LaundryOwnerService laundryOwnerService;

    @GetMapping("/owners")
    public List getOwners() throws ExecutionException, InterruptedException {
        return laundryOwnerService.getOwners();
    }

    @GetMapping("/owner")
    public Object getOrder(@RequestParam String email) throws ExecutionException, InterruptedException {
        return laundryOwnerService.getOwner(email);
    }

    @PostMapping("/owner/register")
    public List order(@RequestBody LaundryOwners laundryOwners) throws ExecutionException, InterruptedException {
        return laundryOwnerService.addOwner(laundryOwners);
    }

    @DeleteMapping("/owner/delete")
    public List deleteOrder(@RequestParam String email) throws ExecutionException, InterruptedException {
        return laundryOwnerService.deleteOwner(email);
    }
}
