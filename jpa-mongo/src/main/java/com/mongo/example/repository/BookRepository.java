package com.mongo.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.example.entities.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
