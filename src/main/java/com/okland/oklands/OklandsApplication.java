package com.okland.oklands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OklandsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext  context = SpringApplication.run(OklandsApplication.class, args);
		String[] names = context.getBeanDefinitionNames();
			System.out.println(names.length);
	}

}
