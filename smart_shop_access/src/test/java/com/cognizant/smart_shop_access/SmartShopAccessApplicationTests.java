package com.cognizant.smart_shop_access;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.smart_shop_access.entity.Bill;
import com.cognizant.smart_shop_access.entity.Product;
import com.cognizant.smart_shop_access.entity.Purchase;
import com.cognizant.smart_shop_access.entity.PurchaseDetails;
import com.cognizant.smart_shop_access.entity.User;
import com.cognizant.smart_shop_access.repository.ProductRepository;
import com.cognizant.smart_shop_access.repository.PurchaseDetailsRepository;
import com.cognizant.smart_shop_access.repository.PurchaseRepository;
import com.cognizant.smart_shop_access.repository.UserRepository;
import com.cognizant.smart_shop_access.service.ProductService;
import com.cognizant.smart_shop_access.service.StockService;
import com.cognizant.smart_shop_access.service.SuperUserService;

//@SpringBootTest
class SmartShopAccessApplicationTests {
	
//	@Autowired
//	private AuthenticationController authenticationController;
	@Autowired
	private SuperUserService superUserService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StockService stockService;
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private PurchaseDetailsRepository purchaseDetailsRepository;
	
//	@Test
	void getPendingUsersTest() {
		List<User> userList = superUserService.getPendingUsers();
		for(User user:userList){
			assertEquals("P",user.getStatus());
		}
	}
	
//	@Test
	void editPendingUserStatusTest() {
		User user = userRepository.findById("admin").get();
		user.setStatus("P");
		superUserService.editPendingUserStatus(user);
		user = userRepository.findById("admin").get();
		assertEquals("P",user.getStatus());
		user.setStatus("D");
		superUserService.editPendingUserStatus(user);
		user = userRepository.findById("admin").get();
		assertEquals("D",user.getStatus());
		user.setStatus("A");
		superUserService.editPendingUserStatus(user);
		user = userRepository.findById("admin").get();
		assertEquals("A", user.getStatus());
	}
	
//	@Test
	void getAllProductsTest() {
		List<Product> productList = productService.getAllProducts();
		for(Product product:productList){
			assertEquals(false, product.equals(null));
		}
	}
	
//	@Test
	void addEditProductTest() {
		Product product = new Product("Dummy","Dummy Product","Temporary","Dump","Unit","45",
				123,new Date(13,8,2019),"F","42",new Date(13,05,2019),new Date(13,11,2019),"No image Available");
		productService.addEditProduct(product);
		assertEquals(product.getAdd_date(), productRepository.findById(product.getCode()).get().getAdd_date());
		assertEquals(product.getAisle(), productRepository.findById(product.getCode()).get().getAisle());
		assertEquals(product.getBrand(), productRepository.findById(product.getCode()).get().getBrand());
		assertEquals(product.getCode(), productRepository.findById(product.getCode()).get().getCode());
		assertEquals(product.getDate_of_expiry(), productRepository.findById(product.getCode()).get().getDate_of_expiry());
		assertEquals(product.getDate_of_manufacture(), productRepository.findById(product.getCode()).get().getDate_of_manufacture());
		assertEquals(product.getImage(), productRepository.findById(product.getCode()).get().getImage());
		assertEquals(product.getName(), productRepository.findById(product.getCode()).get().getName());
		assertEquals(product.getQuantity_type(), productRepository.findById(product.getCode()).get().getQuantity_type());
		assertEquals(product.getRate_per_quantity(), productRepository.findById(product.getCode()).get().getRate_per_quantity());
		assertEquals(product.getShelf(), productRepository.findById(product.getCode()).get().getShelf());
		assertEquals(product.getStock_count(), productRepository.findById(product.getCode()).get().getStock_count());
		assertEquals(product.getType(), productRepository.findById(product.getCode()).get().getType());
		product.setAisle("G");
		product.setBrand("12");
		productService.addEditProduct(product);
		assertEquals(product.getAdd_date(), productRepository.findById(product.getCode()).get().getAdd_date());
		assertEquals(product.getAisle(), productRepository.findById(product.getCode()).get().getAisle());
		assertEquals(product.getBrand(), productRepository.findById(product.getCode()).get().getBrand());
		assertEquals(product.getCode(), productRepository.findById(product.getCode()).get().getCode());
		assertEquals(product.getDate_of_expiry(), productRepository.findById(product.getCode()).get().getDate_of_expiry());
		assertEquals(product.getDate_of_manufacture(), productRepository.findById(product.getCode()).get().getDate_of_manufacture());
		assertEquals(product.getImage(), productRepository.findById(product.getCode()).get().getImage());
		assertEquals(product.getName(), productRepository.findById(product.getCode()).get().getName());
		assertEquals(product.getQuantity_type(), productRepository.findById(product.getCode()).get().getQuantity_type());
		assertEquals(product.getRate_per_quantity(), productRepository.findById(product.getCode()).get().getRate_per_quantity());
		assertEquals(product.getShelf(), productRepository.findById(product.getCode()).get().getShelf());
		assertEquals(product.getStock_count() , productRepository.findById(product.getCode()).get().getStock_count());
		assertEquals(product.getType(), productRepository.findById(product.getCode()).get().getType());
		deleteProductTest();
	}
	

	void deleteProductTest() {
		productService.deleteProduct("Dummy");
		assertEquals(false , productRepository.findById("Dummy").isPresent());
	}
	
//	@Test
	void stockTest() {
		List<Product> productList = productService.getAllProducts();
		List<Integer> quantitiesList = new ArrayList<Integer>();
		int totalAmount = 0;
		for(int i = 0 ; i < productList.size() ; i++) {
			quantitiesList.add(i);
			totalAmount = (int) (i * Float.parseFloat(productList.get(i).getRate_per_quantity()));
		}
		Bill bill = new Bill(productList,quantitiesList,totalAmount,"0123456789");
		Purchase purchase = stockService.generateBill(bill);
		Purchase newPurchase = purchaseRepository.findById(purchase.getId()).get();
		assertEquals(bill.getContactNumber(), newPurchase.getUser().getContactnumber());
		assertEquals(bill.getTotalAmount(), newPurchase.getTotal_amount());
		assertEquals(bill.getTotalAmount()/10, newPurchase.getReward_points());
		List<PurchaseDetails> purchaseDetailsList = purchaseDetailsRepository.findAllByPurchase(newPurchase);
		for(int i = 0;i<purchaseDetailsList.size();i++){
			assertEquals(productList.get(i).getCode(), purchaseDetailsList.get(i).getProduct());
			assertEquals(quantitiesList.get(i), purchaseDetailsList.get(i).getQuantity());
		}
	}

}
