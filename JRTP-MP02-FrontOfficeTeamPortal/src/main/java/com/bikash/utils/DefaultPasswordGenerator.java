package com.bikash.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class DefaultPasswordGenerator {
	
	private DefaultPasswordGenerator()
	{
		
	}
	public static String generatePassword()
	{
		return RandomStringUtils.randomAlphanumeric(6);
	}
}
