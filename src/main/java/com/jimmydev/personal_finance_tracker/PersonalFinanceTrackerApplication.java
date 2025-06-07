package com.jimmydev.personal_finance_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class PersonalFinanceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceTrackerApplication.class, args);
	}

}
