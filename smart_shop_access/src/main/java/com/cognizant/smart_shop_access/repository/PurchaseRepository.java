package com.cognizant.smart_shop_access.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.smart_shop_access.entity.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

}
