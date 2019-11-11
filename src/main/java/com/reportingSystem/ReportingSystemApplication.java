package com.reportingSystem;

import com.reportingSystem.model.RoleModel;
import com.reportingSystem.repository.RoleRepository;
import com.reportingSystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ReportingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportingSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner init (RoleRepository roleRepository){
		return args -> {
			List<String> names = Arrays.asList("ROLE_USER", "ROLE_WORKER", "ROLE_ADMIN");
			names.forEach(name -> roleRepository.save(new RoleModel(name)));
		};
	}
}
