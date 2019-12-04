package com.cognizant.smart_shop_registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.smart_shop_registration.entity.User;

public interface RegistrationRepository extends JpaRepository<User, String> {

	Optional<User> findById(String id);
}
