package com.comic.service;

import com.comic.entity.ShippingAddress;
import com.comic.entity.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
	
	void save(ShippingAddress shippingAddress);
}
