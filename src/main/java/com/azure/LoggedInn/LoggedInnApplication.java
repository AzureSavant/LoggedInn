package com.azure.LoggedInn;

import com.azure.LoggedInn.models.Role;
import com.azure.LoggedInn.models.User;
import com.azure.LoggedInn.service.impl.UserServiceImpl;
import com.azure.LoggedInn.shared.RoleNameConst;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.azure.LoggedInn.mappers",
		"com.azure.LoggedInn.service",
		"com.azure.LoggedInn.config",
		"com.azure.LoggedInn.controllers"})
public class LoggedInnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggedInnApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserServiceImpl userService){
		return args -> {
			userService.saveRole(new Role(RoleNameConst.ADMIN));
			userService.saveRole(new Role(RoleNameConst.HOST));
			userService.saveRole(new Role(RoleNameConst.TRAVELER));

			userService.saveUser(new User("tom","cruise","123","to@mail.com"));
			userService.saveUser(new User("Jom","cruise","123","tto@mail.com","123922424"));

			userService.addRoleToUser("to@mail.com",RoleNameConst.HOST);
			userService.addRoleToUser("tto@mail.com",RoleNameConst.TRAVELER);
			userService.addRoleToUser("tto@mail.com",RoleNameConst.ADMIN);
		};
	}
}
