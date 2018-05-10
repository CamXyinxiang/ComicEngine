package com.comic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.entity.ShippingAddress;
import com.comic.entity.UserShipping;
import com.comic.repository.ShippingAddressRepository;
import com.comic.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {
	
	
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	
	
	
	public ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress) {
		shippingAddress.setShippingAddressName(userShipping.getUserShippingName());
		shippingAddress.setShippingAddressStreet(userShipping.getUserShippingStreet());
		shippingAddress.setShippingAddressCity(userShipping.getUserShippingCity());
		shippingAddress.setShippingAddressState(userShipping.getUserShippingState());
		shippingAddress.setShippingAddressCountry(userShipping.getUserShippingCountry());
		shippingAddress.setShippingAddressZipcode(userShipping.getUserShippingZipcode());
		
		return shippingAddress;
	}
	
	public void save(ShippingAddress shippingAddress){
		shippingAddressRepository.save(shippingAddress);
	}
	
	
}
