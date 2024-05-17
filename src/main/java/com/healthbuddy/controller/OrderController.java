package com.healthbuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbuddy.exceptions.OrderException;
import com.healthbuddy.exceptions.UserException;
import com.healthbuddy.model.Address;
import com.healthbuddy.model.Order;
import com.healthbuddy.model.User;
import com.healthbuddy.services.OrderService;
import com.healthbuddy.services.UserService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<Order> createdOrder(
			@RequestBody Address shippingAddress,
			@RequestHeader("Authorization")String jwt) throws UserException
	{
		User user = userService.findUserProfileByJwt(jwt);	
		Order order = orderService.createOrder(user, shippingAddress);
		
		System.out.println("Order : "+order);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<Order>>userOrderHistory(
			@RequestHeader("Authorization")String jwt) throws UserException
	{
		User user = userService.findUserProfileByJwt(jwt);
		List<Order> orders = orderService.usersOrderHistory(user.getId());
		
		return new ResponseEntity<>(orders,HttpStatus.CREATED);
	}
	
	@GetMapping("{Id}")
	public ResponseEntity<Order> findOrderById(
			@PathVariable("Id")Long orderId,
			@RequestHeader("Authorization")String jwt) throws UserException, OrderException{
		User user = userService.findUserProfileByJwt(jwt);
		Order ordr = orderService.findOrderById(orderId);
		
		return new ResponseEntity<>(ordr,HttpStatus.ACCEPTED);
	}
	
}
