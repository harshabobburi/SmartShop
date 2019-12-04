package com.cognizant.smart_shop_access.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.smart_shop_access.entity.User;
import com.cognizant.smart_shop_access.repository.UserRepository;

@Service
public class SuperUserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getPendingUsers() {
		return userRepository.findAllByStatus("P");
	}
	
	public void editPendingUserStatus(User user) {
		User existingUser = userRepository.findById(user.getId()).get();
		existingUser.setStatus(user.getStatus());
		userRepository.save(existingUser);				
	}
}
