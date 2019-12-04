package com.cognizant.smart_shop_access.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smart_shop_access.entity.User;
import com.cognizant.smart_shop_access.service.SuperUserService;

@RestController
public class SuperUserController {

	@Autowired
	private SuperUserService superUserService;
	
	@GetMapping("/pendingRegistration")
	public List<User> getPendingUsers() {
		return superUserService.getPendingUsers();
	}
	
	@PostMapping("/editUserStatus")
	public List<User> editPendingUserStatus(@RequestBody User user) {
		superUserService.editPendingUserStatus(user);
		return superUserService.getPendingUsers();
	}
	
}
