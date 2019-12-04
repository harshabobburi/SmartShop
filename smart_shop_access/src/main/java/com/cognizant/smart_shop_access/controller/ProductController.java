package com.cognizant.smart_shop_access.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.smart_shop_access.entity.Product;
import com.cognizant.smart_shop_access.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/allProducts")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PostMapping("/addEditProduct")
	public void addEditProduct(@RequestBody Product product) {
		productService.addEditProduct(product);
	}
	
	@DeleteMapping("/deleteProduct/{productCode}")
	public void deleteProduct(@PathVariable String productCode){
		productService.deleteProduct(productCode);
	}
	
}
