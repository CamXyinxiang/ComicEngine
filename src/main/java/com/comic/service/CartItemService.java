package com.comic.service;

import java.util.List;

import com.comic.entity.Comic;
import com.comic.entity.CartItem;
import com.comic.entity.ShoppingCart;
import com.comic.entity.User;

public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addComicToCartItem(Comic comic, User user, int qty);
	
	CartItem findById(Long id);
	
	void removeCartItem(CartItem cartItem);
}
