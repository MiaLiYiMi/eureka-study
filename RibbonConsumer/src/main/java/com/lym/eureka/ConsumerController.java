package com.lym.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	
	@Value(value="${spring.request.hello.service}")
	private String requestUrl;
	
	@Autowired
	RestTemplate restTemplate;

	/**
	 * GET 
	 * @return
	 */
	@RequestMapping(value="/ribbon-consumer",method=RequestMethod.GET)
	public  String helloConsumer() {
		return restTemplate.getForEntity(requestUrl+"hello", String.class).getBody();
	}
}
