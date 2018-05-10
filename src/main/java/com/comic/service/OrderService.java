package com.comic.service;

import com.comic.entity.BillingAddress;
import com.comic.entity.Order;
import com.comic.entity.Payment;
import com.comic.entity.ShippingAddress;
import com.comic.entity.ShoppingCart;
import com.comic.entity.User;


public interface OrderService {
	
	
	Order setOrder(
			Order order,
			ShippingAddress shippingAddress,
			Payment payment,
			BillingAddress billingAddress,
			ShoppingCart shoppingCart,
			String shippingMethod,
			User user);


	Order findOne(Long id);
}