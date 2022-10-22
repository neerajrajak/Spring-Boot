package com.relationship.example.repository;

import com.relationship.example.dto.CustProdNameResponse;
import com.relationship.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Below query is related to hibernate hql and not related to sql
    @Query("Select new com.relationship.example.dto.CustProdNameResponse(c.name, p.productName) from Customer c Join c.products p")
    public List<CustProdNameResponse> getJoinInfo();
}
