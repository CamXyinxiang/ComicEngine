package com.comic.serviceImpl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.entity.BillingAddress;
import com.comic.entity.Comic;
import com.comic.entity.CartItem;
import com.comic.entity.Order;
import com.comic.entity.Payment;
import com.comic.entity.ShippingAddress;
import com.comic.entity.ShoppingCart;
import com.comic.entity.User;
import com.comic.repository.OrderRepository;
import com.comic.service.CartItemService;
import com.comic.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	private Logger log=Logger.getLogger(getClass().getName());
	
	
	@Autowired
	private CartItemService cartItemService;
	
	
	@Autowired
	private OrderRepository orderRepository;
	
	public synchronized Order setOrder(Order order,ShippingAddress shippingAddress, Payment payment,
			BillingAddress billingAddress, ShoppingCart shoppingCart,
			String shippingMethod, User user) {
			
		order.setBillingAddress(billingAddress);
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		order.setUser(user);
		
		List<CartItem> list=cartItemService.findByShoppingCart(shoppingCart);
		
		order.setCartItemList(list);
		
		for(CartItem cartItem:list){
			Comic comic=cartItem.getComic();
			if(comic.getInStockNumber()<cartItem.getQty())
				log.info("Comic number not enough");
			comic.setInStockNumber(comic.getInStockNumber()-cartItem.getQty());
			cartItem.setOrder(order);
		}
			order.setOrderTotal(shoppingCart.getGrandTotal());
			
			shippingAddress.setOrder(order);
			billingAddress.setOrder(order);
			payment.setOrder(order);
			
			shippingAddress.setUser(user);
			
			order.setOrderDate(Calendar.getInstance().getTime());
		
			orderRepository.save(order);
		
		return order;
	}
	
	public Order findOne(Long id){
		return orderRepository.findOne(id);
		
	}
	

}
