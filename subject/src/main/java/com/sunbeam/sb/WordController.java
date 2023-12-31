package com.sunbeam.sb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	@Value("${words}")
	private String words;
	@GetMapping
	public String getWord(HttpServletRequest req) {
		String[] wordArray = words.split(",");
		int i = (int)Math.round(Math.random() * (wordArray.length - 1));
		String word =  wordArray[i];
		System.out.println(word + " served from " + req.getRequestURL());
		return word;
	}
}

