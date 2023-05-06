package com.app.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddHealthServiceToCartDto;
import com.app.dtos.CartHealthServiceIdDto;
import com.app.pojos.HealthServiceEntity;
import com.app.services.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private JavaMailSender sender;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourseToCart(@RequestBody AddHealthServiceToCartDto courseToCartDto) {
		return new ResponseEntity<>(cartService.addHealthServiceToCart(courseToCartDto), HttpStatus.OK);
	}
	
	@GetMapping("/{userid}")
	public ResponseEntity<?> getCourseInCartByUserId(@PathVariable("userid") Long userid) {
		List<HealthServiceEntity> savedHealthServiceEntity = cartService.getHealthServiceInCartByUserId(userid);
		return new ResponseEntity<>(savedHealthServiceEntity, HttpStatus.OK);
	}
	
	@GetMapping("/cartTotal/{userid}")
	public ResponseEntity<?> getCartTotalByUserId(@PathVariable("userid") Long userid) {
		Long cartTotal = cartService.getCartTotalByUserId(userid);
		return new ResponseEntity<>(cartTotal, HttpStatus.OK);
	}
	
	@PostMapping("/remove")
	public ResponseEntity<?> dropItemFromCart(@RequestBody CartHealthServiceIdDto cartCourseIdDto){	
		return new ResponseEntity<>(cartService.dropItemFromCart(cartCourseIdDto), HttpStatus.OK);
	}
}
