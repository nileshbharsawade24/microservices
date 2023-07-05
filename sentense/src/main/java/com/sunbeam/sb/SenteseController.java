package com.sunbeam.sb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenteseController {
	@Autowired
	private SentenseServiceImpl sentenseService;

	@GetMapping("/")
	public String sentense() {
		return sentenseService.getSentense();
	}
}

