package com.sunbeam.sb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class SentenseServiceImpl {
	@Autowired
	private RestTemplate restTemplate;
	
	// hard-coded url for subject, http://localhost:8081/
	// if serviceId=subject, then older url http://localhost:dynamic_port/
	// if serviceId=subject, then new url http://subject/
	
	public String getWord(String serviceId) {
		// automated service discovery & load balancing
		try {
			String url = "http://"+serviceId+"/";
			String word = restTemplate.getForObject(url, String.class);
			return word;
		} catch (RestClientException e) {
			return getDefaultWord(serviceId);
		}
	}
	
	public String getDefaultWord(String serviceId) {
		return "x";
	}
	
	public String getSentense() {
		String subject = getWord("subject");
		String verb = getWord("verb");
		String article = getWord("article");
		String adjective = getWord("adjective");
		String noun = getWord("noun");
		String sentense = subject + " " + verb + " " + article + " " + adjective + " " + noun;
		return sentense;
	}
}

/*
@Service
public class SentenseServiceImpl {
	@Autowired
	private RestTemplate restTemplate;
		
	// service discovery
	@Autowired
	private DiscoveryClient discClient;
	public String getInstanceUrl(String serviceId) {
		List<ServiceInstance> list = discClient.getInstances(serviceId);
		if(list != null && !list.isEmpty()) {
			ServiceInstance inst = list.get(0);
			return inst.getUri().toString();
		}
		return null;
	}
	
	public String getWord(String serviceId) {
		String url = getInstanceUrl(serviceId);
		String word = restTemplate.getForObject(url, String.class);
		return word;
	}
	
	public String getSentense() {
		String subject = getWord("subject");
		String verb = getWord("verb");
		String article = getWord("article");
		String adjective = getWord("adjective");
		String noun = getWord("noun");
		String sentense = subject + " " + verb + " " + article + " " + adjective + " " + noun;
		return sentense;
	}
}
*/

/*
@Service
public class SentenseServiceImpl {
	@Autowired
	private RestTemplate restTemplate;
	
	private String subjectUrl = "http://localhost:8081/";
	private String verbUrl = "http://localhost:8082/";
	private String articleUrl = "http://localhost:8083/";
	private String adjectiveUrl = "http://localhost:8084/";
	private String nounUrl = "http://localhost:8085/";
	
	public String getWord(String url) {
		String word = restTemplate.getForObject(url, String.class);
		return word;
	}
	
	public String getSentense() {
		String subject = getWord(subjectUrl);
		String verb = getWord(verbUrl);
		String article = getWord(articleUrl);
		String adjective = getWord(adjectiveUrl);
		String noun = getWord(nounUrl);
		String sentense = subject + " " + verb + " " + article + " " + adjective + " " + noun;
		return sentense;
	}
}
*/

