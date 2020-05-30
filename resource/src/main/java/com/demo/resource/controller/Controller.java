package com.demo.resource.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@GetMapping("/resource")
	public String resource(@AuthenticationPrincipal Jwt jwt) {
		LOGGER.info("***** JWT Headers: {}", jwt.getHeaders());
		LOGGER.info("***** JWT Claims: {}", jwt.getClaims().toString());
		LOGGER.info("***** JWT Token: {}", jwt.getTokenValue());
		return String.format("Resource accessed successfully (with subjectId: %s)", jwt.getSubject());
	}

}
