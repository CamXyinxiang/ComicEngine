package com.comic.repository;

import org.springframework.data.repository.CrudRepository;

import com.comic.entity.BillingAddress;

public interface BillingAddressRepository extends CrudRepository<BillingAddress, Long>{

}
