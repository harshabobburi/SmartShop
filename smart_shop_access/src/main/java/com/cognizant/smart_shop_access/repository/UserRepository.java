package com.cognizant.smart_shop_access.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.smart_shop_access.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	Optional<User> findById(String id);
	
	List<User> findAllByStatus(String status);
	
	User findByContactnumber(String contactnumber);
}
