package com.example.actuator.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/demo")
public class SimpleRestController {
	@GetMapping(value = "/example")
	public String example() {
		return "Hello User !! " + new Date();
	}
}