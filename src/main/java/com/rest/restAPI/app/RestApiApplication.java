package com.rest.restAPI.app;

import com.rest.restAPI.app.repo.CusRepo;
import com.rest.restAPI.app.repo.EmployeeRepo;
import com.rest.restAPI.app.repo.ProductRepo;
import com.rest.restAPI.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.rest.restAPI.app")
public class RestApiApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.	run(RestApiApplication.class, args);
	}

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CusRepo cusRepo;

	@Autowired
	private ProductRepo productRepo;


	@Override
	public void run(String... args) throws Exception {

		/*Customer cus = new Customer();
		cus.setId(21);
		cus.setUsername("afj");
		cus.setFirstname("Yas");
		cus.setLastname("Jaya");
		cus.setPassword("12345");
		cus.setAddress("Veyangoda");
		cus.setPhone("01122345");
		cusRepo.save(cus);*/

	}

}
