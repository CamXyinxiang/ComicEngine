package com.comic.service;

import com.comic.entity.BillingAddress;
import com.comic.entity.ShippingAddress;
import com.comic.entity.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
	
	BillingAddress setByShippingAddress(ShippingAddress shippingAddress, BillingAddress billingAddress);
	
	
	void save(BillingAddress billingAddress);
}
