package com.swd.e_bake_ingredients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EBakeIngredientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBakeIngredientsApplication.class, args);
	}

}
