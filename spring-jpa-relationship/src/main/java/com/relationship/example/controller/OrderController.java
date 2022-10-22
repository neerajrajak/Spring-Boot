package com.relationship.example.controller;

import com.relationship.example.dto.CustProdNameResponse;
import com.relationship.example.dto.OrderRequest;
import com.relationship.example.entity.Customer;
import com.relationship.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public Customer saveCustomer(@RequestBody OrderRequest orderRequest){
        return orderService.saveCustomer(orderRequest.getCustomer());
    }

    @GetMapping("/allOrders")
    public List<Customer> findAllOrders(){
        return orderService.findAllOrders();
    }

    @GetMapping("/getJoinInfo")
    public List<CustProdNameResponse> getJoinInformation(){
        return orderService.getJoinInformation();
    }
}
