package com.mongo.example.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="user")
public class User {
	
	@Id
	private int id;
	private String name;
	private String gender;
	public List<Product> products;
	public Address address;
}
