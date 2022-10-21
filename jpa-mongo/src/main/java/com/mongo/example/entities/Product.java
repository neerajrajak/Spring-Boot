package com.mongo.example.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Product {

	private String productName;
	private int quantity;
	private int price;
}
