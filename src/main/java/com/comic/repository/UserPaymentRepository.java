package com.comic.repository;

import org.springframework.data.repository.CrudRepository;

import com.comic.entity.UserPayment;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long>{

}
