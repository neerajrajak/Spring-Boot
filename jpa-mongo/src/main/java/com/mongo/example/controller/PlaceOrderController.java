package com.mongo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.example.entities.User;
import com.mongo.example.repository.FlipkartRepository;

@RestController
@RequestMapping("/order")
public class PlaceOrderController {

	@Autowired
	private FlipkartRepository flipkartRepository;
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody User user) {
		flipkartRepository.save(user);
		return "Order is Placed successfully: "+user.getId();
	}
	
	@GetMapping("getAllUserProduct")
	public List<User> getUserByCity(){
		return flipkartRepository.findAll();
	}
	
	@GetMapping("getUserByName/{name}")
	public List<User> getUserByName(@PathVariable String name){
		return flipkartRepository.findByName(name);
	}
	
	@GetMapping("getUserByCity/{city}")
	public List<User> getUserByCity(@PathVariable String city){
		return flipkartRepository.findByCity(city);
	}
}
