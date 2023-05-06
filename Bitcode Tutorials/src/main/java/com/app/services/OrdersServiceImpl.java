package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.PlaceOrderDto;
import com.app.pojos.Cart;
import com.app.pojos.Order;
import com.app.pojos.TransactionDetail;
import com.app.pojos.User;
import com.app.repositories.OrderRepository;
import com.app.repositories.TransactionsRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private TransactionsRepository transactionsRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String placeOrder(PlaceOrderDto placeOrderDto) {
		User user = userRepo.findById(placeOrderDto.getUserid()).orElseThrow(() -> new RuntimeException("User not found"));
		Cart cart = user.getCart();
		Order order = mapper.map(placeOrderDto, Order.class);
		TransactionDetail transactionDetail = mapper.map(placeOrderDto, TransactionDetail.class);
		
		order.addCartHealthServicesToOrder(cart.getCartHealthServices());
		order.setTransactionDetail(transactionDetail);
		order.setUser(user);
		
		transactionDetail.setOrder(order);
		
		user.addServiceToUser(cart.getCartHealthServices());
		
		cart.emptyCartCourses();
		
		orderRepo.save(order);
		transactionsRepo.save(transactionDetail);
		return "Order Placed Successfully";
	}
}
