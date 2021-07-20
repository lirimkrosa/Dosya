package com.dosja.Dosja;

import com.dosja.Dosja.model.Role;
import com.dosja.Dosja.model.Users;
import com.dosja.Dosja.security.SpringSecurityAuditorAware;
import com.dosja.Dosja.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")

public class DosjaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DosjaApplication.class, args);
	}

	@Bean
	public SpringSecurityAuditorAware auditorAware() {
		return new SpringSecurityAuditorAware();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	@Autowired
	UserService userService;

	@Override
	public void run(String... params) throws Exception {
		Users admin = new Users();
		admin.setUsername("admin");
		admin.setPassword("admin");
		admin.setEmail("admin@email.com");
		admin.setFull_name("Lirim Krosa");
		admin.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

		userService.signup(admin);

		Users client = new Users();
		client.setUsername("client");
		client.setPassword("client");
		client.setEmail("client@email.com");
		client.setFull_name("Lirim Krosa");
		client.setRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_CLIENT)));

		userService.signup(client);
	}


}
