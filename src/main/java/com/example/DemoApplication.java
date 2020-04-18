package com.example;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoApplication.class)
				//.properties("spring.cloud.bootstrap.enabled=false")
				.run(args);
	}

	@Bean
	public ApplicationRunner runner(MyProperties properties) {
		return (arguments) -> {
			System.out.println("----------------------------");
			System.out.println("Token " + properties.getToken());
			System.out.println("URI " + properties.getServer());
			System.out.println("----------------------------");
		};
	}

}
