package com.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.util.StringUtils;

class TestEnvironmentPostProcessor implements EnvironmentPostProcessor {

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		String token = environment.getProperty("my.token");
		if (!StringUtils.hasText(token)) {
			System.out.println("my.token not found");
			Map<String, Object> settings = new HashMap<>();
			settings.put("my.token", "abc-def");
			if (!environment.containsProperty("my.server")) {
				settings.put("my.server", "https://fallback.example.com");
			}
			MapPropertySource sampleSource = new MapPropertySource("sample", settings);
			environment.getPropertySources().addLast(sampleSource);
		}
		else {
			System.out.println("my.token found, no need to do anything");
		}
	}
}
