package com.comic.service;

import com.comic.entity.Payment;
import com.comic.entity.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
	
	void save(Payment payment);	
}
