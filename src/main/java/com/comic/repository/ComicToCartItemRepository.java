package com.comic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.comic.entity.ComicToCartItem;
import com.comic.entity.CartItem;

@Transactional
public interface ComicToCartItemRepository extends CrudRepository<ComicToCartItem, Long> {
	void deleteByCartItem(CartItem cartItem);
}
