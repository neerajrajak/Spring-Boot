package com.relationship.example.service;

import com.relationship.example.dto.CustProdNameResponse;
import com.relationship.example.dto.OrderRequest;
import com.relationship.example.entity.Customer;
import com.relationship.example.repository.CustomerRepository;
import com.relationship.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> findAllOrders(){
        return customerRepository.findAll();
    }

    public List<CustProdNameResponse> getJoinInformation(){
        return customerRepository.getJoinInfo();
    }

}
