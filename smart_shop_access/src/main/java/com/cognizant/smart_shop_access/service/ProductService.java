package com.cognizant.smart_shop_access.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.smart_shop_access.entity.Product;
import com.cognizant.smart_shop_access.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	public void addEditProduct(Product product) {
		Optional<Product> result = productRepository.findById(product.getCode());
		if(result.isPresent()){
			result.get().setAdd_date(product.getAdd_date());
			result.get().setAisle(product.getAisle());
			result.get().setBrand(product.getBrand());
			result.get().setDate_of_expiry(product.getDate_of_expiry());
			result.get().setDate_of_manufacture(product.getDate_of_manufacture());
			result.get().setImage(product.getImage());
			result.get().setName(product.getName());
			result.get().setQuantity_type(product.getQuantity_type());
			result.get().setRate_per_quantity(product.getRate_per_quantity());
			result.get().setShelf(product.getShelf());
			result.get().setStock_count(product.getStock_count());
			result.get().setType(product.getType());
			productRepository.save(result.get());
		}
		else{
			productRepository.save(product);
		}
	}
	
	public void deleteProduct(String productCode){
		productRepository.deleteById(productCode);
	}
}
