package com.cognizant.smart_shop_registration.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.smart_shop_registration.entity.User;
import com.cognizant.smart_shop_registration.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	public boolean register(User newUser) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		Optional<User> result = registrationRepository.findById(newUser.getId());
		if(result.isPresent()){
			return false;
		}
		else{
			registrationRepository.save(newUser);
			return true;
		}
	}
}
