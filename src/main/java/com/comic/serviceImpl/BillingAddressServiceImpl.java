package com.comic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.entity.BillingAddress;
import com.comic.entity.ShippingAddress;
import com.comic.entity.UserBilling;
import com.comic.repository.BillingAddressRepository;
import com.comic.service.BillingAddressService;

@Service
public class BillingAddressServiceImpl implements BillingAddressService{
	
	
	@Autowired
	private BillingAddressRepository billingAddressRepository;
	
	public BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress) {
		billingAddress.setBillingAddressName(userBilling.getUserBillingName());
		billingAddress.setBillingAddressStreet(userBilling.getUserBillingStreet());
		billingAddress.setBillingAddressCity(userBilling.getUserBillingCity());
		billingAddress.setBillingAddressState(userBilling.getUserBillingState());
		billingAddress.setBillingAddressCountry(userBilling.getUserBillingCountry());
		billingAddress.setBillingAddressZipcode(userBilling.getUserBillingZipcode());
		
		return billingAddress;
	}
	
	
	public BillingAddress setByShippingAddress(
			ShippingAddress shippingAddress,BillingAddress billingAddress){
		billingAddress.setBillingAddressName(shippingAddress.getShippingAddressName());
		billingAddress.setBillingAddressStreet(shippingAddress.getShippingAddressStreet());
		billingAddress.setBillingAddressCity(shippingAddress.getShippingAddressCity());
		billingAddress.setBillingAddressState(shippingAddress.getShippingAddressState());
		billingAddress.setBillingAddressCountry(shippingAddress.getShippingAddressCountry());
		billingAddress.setBillingAddressZipcode(shippingAddress.getShippingAddressZipcode());
		
		return billingAddress;
	}

	public void save(BillingAddress billingAddress){
		billingAddressRepository.save(billingAddress);
		
	}

	
	
}
