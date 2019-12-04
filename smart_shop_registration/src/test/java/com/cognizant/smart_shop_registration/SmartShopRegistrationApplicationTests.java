package com.cognizant.smart_shop_registration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.smart_shop_registration.entity.User;
import com.cognizant.smart_shop_registration.repository.RegistrationRepository;
import com.cognizant.smart_shop_registration.service.RegistrationService;

//@SpringBootTest
class SmartShopRegistrationApplicationTests {
	
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private RegistrationRepository registrationRepository;

//	@Test
	void registerNewUser() {
		User userNew = new User("Smart","Very","Intelligent",65,"Female",
				"0987654321","pass","U","A","SQ1","SQ2","SQ3","SA1","SA2","SA3");
		assertEquals(false, registrationService.register(userNew),
				"Trying to create user user Id returns true and adds the user");
		Optional<User> result = registrationRepository.findById(userNew.getId());
		assertEquals(result.isPresent(), true);
		assertEquals(userNew.getId(), result.get().getId(),"Created user is successfully added to the database");
		assertEquals(userNew.getAge(), result.get().getAge(),"Created user is successfully added to the database");
		assertEquals(userNew.getContactnumber(), result.get().getContactnumber(),"Created user is successfully added to the database");
		assertEquals(userNew.getFirstname(), result.get().getFirstname(),"Created user is successfully added to the database");
		assertEquals(userNew.getGender(), result.get().getGender(),"Created user is successfully added to the database");
		assertEquals(userNew.getLastname(), result.get().getLastname(),"Created user is successfully added to the database");
		assertEquals(userNew.getSecret_answer_1(), result.get().getSecret_answer_1(),"Created user is successfully added to the database");
		assertEquals(userNew.getSecret_answer_2(), result.get().getSecret_answer_2(),"Created user is successfully added to the database");
		assertEquals(userNew.getSecret_answer_3(), result.get().getSecret_answer_3(),"Created user is successfully added to the database");
		assertEquals(userNew.getSecret_question_1(), result.get().getSecret_question_1(),"Created user is successfully added to the database");
		assertEquals(userNew.getSecret_question_2(), result.get().getSecret_question_2(),"Created user is successfully added to the database");
		assertEquals(userNew.getSecret_question_3(), result.get().getSecret_question_3(),"Created user is successfully added to the database");
		assertEquals(userNew.getStatus(), result.get().getStatus(),"Created user is successfully added to the database");
		assertEquals(userNew.getType(), result.get().getType(),"Created user is successfully added to the database");
		registrationRepository.delete(userNew);
	}
	
//	@Test
	void registerOldUser() {
		User userNew = new User("Smart","Very","Intelligent",65,"Female",
				"0987654321","pass","U","A","SQ1","SQ2","SQ3","SA1","SA2","SA3");
		registrationService.register(userNew);
		Optional<User> result = registrationRepository.findById(userNew.getId());
		assertEquals(false, registrationService.register(userNew),
				"Trying to create user with existing user Id returns false and does not add the user");
	}

}
