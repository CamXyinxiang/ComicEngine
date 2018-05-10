package com.comic.repository;

import org.springframework.data.repository.CrudRepository;

import com.comic.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}