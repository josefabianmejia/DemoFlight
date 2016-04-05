package com.payU;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:dataSourceMySql.properties")
public class DemoFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFlightsApplication.class, args);
	}
}
