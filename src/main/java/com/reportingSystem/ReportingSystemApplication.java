package com.reportingSystem;

import com.reportingSystem.dto.UserDto;
import com.reportingSystem.model.RoleModel;
import com.reportingSystem.repository.RoleRepository;
import com.reportingSystem.service.UserService;
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
	CommandLineRunner init (RoleRepository roleRepository, UserService userService){
		return args -> {
			if(roleRepository.findRoleModelByRoleName("ROLE_USER") == null) {
				List<String> names = Arrays.asList("ROLE_USER", "ROLE_WORKER", "ROLE_ADMIN");
				names.forEach(name -> roleRepository.save(new RoleModel(name)));
			}
			if(userService.getUser("admin") == null) {
				UserDto user = new UserDto();
				user.setEmail("admin");
				user.setMobileNumber("662");
				user.setStatus(true);
				user.setUsername("admin");
				user.setPassword(("admin"));
				user.setRoles(Arrays.asList(roleRepository.findRoleModelByRoleName("ROLE_ADMIN")));
				userService.createAdmin(user);
			}
		};
	}
}
