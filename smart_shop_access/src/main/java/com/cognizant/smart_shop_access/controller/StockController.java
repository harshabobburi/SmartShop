package com.cognizant.smart_shop_access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smart_shop_access.entity.Bill;
import com.cognizant.smart_shop_access.service.StockService;

@RestController
public class StockController {
	
	@Autowired
	private StockService stockService;

	@PostMapping("/generateBill")
	public void generateBill(@RequestBody Bill bill) {
		stockService.generateBill(bill);
	}

}
