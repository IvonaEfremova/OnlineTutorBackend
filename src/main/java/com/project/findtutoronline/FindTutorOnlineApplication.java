package com.project.findtutoronline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FindTutorOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindTutorOnlineApplication.class, args);
	}

}
