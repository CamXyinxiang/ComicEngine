package com.comic.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.entity.Payment;
import com.comic.entity.UserPayment;
import com.comic.repository.PaymentRepository;
import com.comic.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
		payment.setType(userPayment.getType());
		payment.setHolderName(userPayment.getHolderName());
		payment.setCardNumber(userPayment.getCardNumber());
		payment.setExpiryMonth(userPayment.getExpiryMonth());
		payment.setExpiryYear(userPayment.getExpiryYear());
		payment.setCvc(userPayment.getCvc());
		
		return payment;
	}
	
	public void save(Payment payment){
		
		paymentRepository.save(payment);
		
	}

}
