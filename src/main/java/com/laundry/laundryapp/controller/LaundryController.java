package com.laundry.laundryapp.controller;

import com.laundry.laundryapp.model.Laundry;
import com.laundry.laundryapp.model.LaundryDataToUpdate;
import com.laundry.laundryapp.model.LaundryOwner;
import com.laundry.laundryapp.service.LaundryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LaundryController {

    @Autowired
    LaundryService laundryService;

    @GetMapping("/owners")
    public List getOwners() throws ExecutionException, InterruptedException {
        return laundryService.getOwners();
    }

    @GetMapping("/owner")
    public Object getOrder(@RequestParam String email) throws ExecutionException, InterruptedException {
        return laundryService.getOwner(email);
    }
    @GetMapping("/laundry-info")
    public List getLaundryInfo() throws ExecutionException, InterruptedException {
        return laundryService.getLaundryData();
    }

    @PostMapping("/owner/register")
    public List order(@RequestBody Laundry laundry) throws ExecutionException, InterruptedException {
        return laundryService.addOwner(laundry);
    }

    @PutMapping("/owner/update")
    public List updateLaundryOwnerData (@RequestBody LaundryDataToUpdate laundryOwner) throws ExecutionException, InterruptedException, IllegalAccessException {
        return  laundryService.updateLaundryOwnerData(laundryOwner);
    }

    @DeleteMapping("/owner/delete")
    public List deleteOrder(@RequestParam String email) throws ExecutionException, InterruptedException {
        return laundryService.deleteOwner(email);
    }
}
