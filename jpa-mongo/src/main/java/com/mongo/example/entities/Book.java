package com.mongo.example.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "book")
public class Book {

	@Id
	private int id;
	private String bookName;
	private String authorName;
}
