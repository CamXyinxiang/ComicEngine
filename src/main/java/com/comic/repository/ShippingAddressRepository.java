package com.comic.repository;

import org.springframework.data.repository.CrudRepository;

import com.comic.entity.ShippingAddress;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {
	
	

}
