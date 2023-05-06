package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.AddHealthServiceToCartDto;
import com.app.dtos.CartHealthServiceIdDto;
import com.app.pojos.Cart;
import com.app.pojos.HealthServiceEntity;
import com.app.pojos.User;
import com.app.repositories.CartRepository;
import com.app.repositories.HealthServiceRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private HealthServiceRepository healthServiceRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String addHealthServiceToCart(AddHealthServiceToCartDto healthServiceToCartDto) {
		Cart cart = cartRepo.findById(healthServiceToCartDto.getCartId()).orElseThrow(() -> new RuntimeException("Cart not found"));
		HealthServiceEntity healthService = healthServiceRepo.findById(healthServiceToCartDto.getHealthServiceId()).orElseThrow(() -> new RuntimeException("HealthService not found"));
		if(cart.addHealthServiceToCart(healthService)) {
			cart.setNoItems(cart.getNoItems()+1);
			cart.setCartTotal(cart.getCartTotal()+healthService.getPrice());
			cartRepo.save(cart);
			return "Course Added to Cart Successfully.";
		}
		return "Course Already Exist in Cart or Purchased";
	}

	@Override
	public List<HealthServiceEntity> getHealthServiceInCartByUserId(Long userid) {
		User user = userRepo.findById(userid).orElseThrow(() -> new RuntimeException("User not found"));
		List<HealthServiceEntity> healthServices = user.getCart().getCartHealthServices();
		return healthServices;
	}

	@Override
	public Long getCartTotalByUserId(Long userid) {
		User user = userRepo.findById(userid).orElseThrow(() -> new RuntimeException("User not found"));
		Long cartTotal = (long) user.getCart().getCartTotal();
		return cartTotal;
	}

	@Override
	public String dropItemFromCart(CartHealthServiceIdDto cartCourseIdDto) {
		System.out.println(cartCourseIdDto);
		Cart cart = cartRepo.findById(cartCourseIdDto.getCartId()).orElseThrow(() -> new RuntimeException("Cart not found"));
		HealthServiceEntity healthService = healthServiceRepo.findById(cartCourseIdDto.getHealthServiceId()).orElseThrow(() -> new RuntimeException("Course not found"));
		cart.removeHealthServiceFromCart(healthService);
		cart.setCartTotal(cart.getCartTotal()-healthService.getPrice());
		cart.setNoItems(cart.getNoItems()-1);
		
		return "Course removed from cart successfully.";
	}	
}