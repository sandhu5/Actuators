package com.example.actuator.ActuatorDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class ActuatorDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorDemoApplication.class, args);
	}
}
