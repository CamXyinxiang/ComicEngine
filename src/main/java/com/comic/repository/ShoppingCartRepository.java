package com.comic.repository;

import org.springframework.data.repository.CrudRepository;

import com.comic.entity.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}
