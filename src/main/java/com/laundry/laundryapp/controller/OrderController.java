package com.laundry.laundryapp.controller;

import com.laundry.laundryapp.model.OrderBook;
import com.laundry.laundryapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List getOrders() throws ExecutionException, InterruptedException {
        return orderService.getOrders();
    }

    @GetMapping("/order")
    public Object getOrder(@RequestParam String email) throws ExecutionException, InterruptedException {
        return orderService.getOrder(email);
    }

    @PostMapping("/order")
    public List order(@RequestBody OrderBook orderBook) throws ExecutionException, InterruptedException {
        return orderService.addOrders(orderBook);
    }

    @DeleteMapping("/order/delete")
    public List deleteOrder(@RequestParam String email) throws ExecutionException, InterruptedException {
        return orderService.deleteOrder(email);
    }

    @GetMapping("/updateState")
    public String updateOrderState(@RequestParam String email, boolean state) throws ExecutionException, InterruptedException {
        return orderService.updateOrderState(email,state);
    }
}
