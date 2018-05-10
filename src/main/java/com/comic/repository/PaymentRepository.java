package com.comic.repository;

import org.springframework.data.repository.CrudRepository;

import com.comic.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long>{

}
