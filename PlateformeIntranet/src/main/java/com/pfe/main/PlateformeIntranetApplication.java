package com.pfe.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = { org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class PlateformeIntranetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlateformeIntranetApplication.class, args);
	}

}
