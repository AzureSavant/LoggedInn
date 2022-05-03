package com.azure.LoggedInn;

import com.azure.LoggedInn.models.Resource;
import com.azure.LoggedInn.models.Role;
import com.azure.LoggedInn.models.User;
import com.azure.LoggedInn.service.impl.ResourceServiceImpl;
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


}
