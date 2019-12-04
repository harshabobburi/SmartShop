package com.cognizant.smart_shop_access.service;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smart_shop_access.entity.Bill;
import com.cognizant.smart_shop_access.entity.Product;
import com.cognizant.smart_shop_access.entity.Purchase;
import com.cognizant.smart_shop_access.entity.PurchaseDetails;
import com.cognizant.smart_shop_access.entity.User;
import com.cognizant.smart_shop_access.repository.ProductRepository;
import com.cognizant.smart_shop_access.repository.PurchaseDetailsRepository;
import com.cognizant.smart_shop_access.repository.PurchaseRepository;
import com.cognizant.smart_shop_access.repository.UserRepository;

@Service
public class StockService {
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private PurchaseDetailsRepository purchaseDetailsRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public Purchase generateBill(Bill bill){
		User user = userRepository.findByContactnumber(bill.getContactNumber());
		Purchase purchase = new Purchase(user, bill.getTotalAmount(), 
				bill.getTotalAmount()/10, new Date(Calendar.getInstance().getTime().getTime()));
		purchaseRepository.save(purchase);
		for(int i = 0; i < bill.getQuantities().size(); i++){
			PurchaseDetails purchaseDetails = new PurchaseDetails(bill.getProducts().get(i).getCode(),purchase ,bill.getQuantities().get(i));
			purchaseDetailsRepository.save(purchaseDetails);
			bill.getProducts().get(i).setStock_count(bill.getProducts().get(i).getStock_count() - bill.getQuantities().get(i));
			productRepository.save(bill.getProducts().get(i));
		}
		return purchase;
	}
}
