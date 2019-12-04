package com.cognizant.smart_shop_access.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.smart_shop_access.entity.AppUser;
import com.cognizant.smart_shop_access.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AppUser appUser;
		if(userRepository.findById(username) == null){
			throw new UsernameNotFoundException(username);
		}
		else {
			appUser = new AppUser(userRepository.findById(username).get());
		}
		return appUser;
	}

	public AppUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
