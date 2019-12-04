package com.cognizant.smart_shop_access.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.smart_shop_access.entity.Purchase;
import com.cognizant.smart_shop_access.entity.PurchaseDetails;

public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Integer> {

	List<PurchaseDetails> findAllByPurchase(Purchase purchase);
}
