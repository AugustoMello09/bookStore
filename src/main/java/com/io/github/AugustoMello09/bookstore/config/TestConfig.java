package com.io.github.AugustoMello09.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.io.github.AugustoMello09.bookstore.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciaBaseDedos() {
		this.dbService.instaciaBaseDeDados();
	}
	
}
