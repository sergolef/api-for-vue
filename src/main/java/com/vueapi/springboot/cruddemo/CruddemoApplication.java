package com.vueapi.springboot.cruddemo;

import com.vueapi.springboot.cruddemo.security.entity.Role;
import com.vueapi.springboot.cruddemo.security.entity.User;
import com.vueapi.springboot.cruddemo.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//userRepository.save(new User("sergey", "olef" ,"test@email.com" ,"Temp!234" , Role.ADMIN));
	}
}
