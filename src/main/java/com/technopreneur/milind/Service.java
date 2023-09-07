package com.technopreneur.milind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Service {
	private Logger logger = LoggerFactory.getLogger(Service.class);

	public String invoke() {
		logger.info("Inside service.invoke method!");
		return "This is from server side !";
		
	}
}
