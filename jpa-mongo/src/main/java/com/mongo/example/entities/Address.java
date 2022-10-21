package com.mongo.example.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {

	private String city;
	private String state;
	private String pincode;
}
