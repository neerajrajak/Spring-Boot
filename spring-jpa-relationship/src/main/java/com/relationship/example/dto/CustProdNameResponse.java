package com.relationship.example.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class CustProdNameResponse {
    private String name;
    private String productName;
    private int price;

    // We have added this customer since we are expecting only this two fields in our query of getJoinInfo
    public CustProdNameResponse(String name, String productName){
        this.name = name;
        this.productName = productName;
    }


}
