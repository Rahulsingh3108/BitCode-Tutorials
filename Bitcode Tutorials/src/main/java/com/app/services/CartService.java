package com.app.services;

import java.util.List;

import com.app.dtos.AddHealthServiceToCartDto;
import com.app.dtos.CartHealthServiceIdDto;
import com.app.pojos.HealthServiceEntity;

public interface CartService {
	String addHealthServiceToCart(AddHealthServiceToCartDto courseToCartDto);
	List<HealthServiceEntity> getHealthServiceInCartByUserId(Long userid);
	Long getCartTotalByUserId(Long userid);
	String dropItemFromCart(CartHealthServiceIdDto cartHealthServiceIdDto);
}
