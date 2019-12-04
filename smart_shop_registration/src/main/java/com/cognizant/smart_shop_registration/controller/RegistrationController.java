package com.cognizant.smart_shop_registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smart_shop_registration.entity.User;
import com.cognizant.smart_shop_registration.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/register")
	public boolean register(@RequestBody User user){
		return registrationService.register(user);
	}
}
