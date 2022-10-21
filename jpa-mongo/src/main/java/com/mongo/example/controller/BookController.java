package com.mongo.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.example.entities.Book;
import com.mongo.example.repository.BookRepository;

@RestController
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBook")
	public String createBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Added Book with Id: "+ book.getId();
	}
	
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/getBook/{bookId}")
	public Optional<Book> getBook(@PathVariable int bookId){
		return bookRepository.findById(bookId);
	}
	
	@DeleteMapping("/deleteBook/{bookId}")
	public String deleteBook(@PathVariable int bookId){
		bookRepository.deleteById(bookId);
		return "Book Deleted with id: "+bookId;
	}
}
