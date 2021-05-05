package com.test.pet.utils;

import java.security.SecureRandom;

public class RandomUtils {
	
	private RandomUtils() {
		
	}
	
	private static final SecureRandom random= new SecureRandom();
	
	public static String generateRandomString(int length) {

		String text ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder(length);
		for( int i = 0; i < length; i++ ) 
			sb.append( text.charAt( random.nextInt(text.length()) ) );
		return sb.toString();

	}

	public static String generateRandomNumericString(int length) {
		String textnumber ="0123456789";
		StringBuilder sb = new StringBuilder(length);
		for( int i = 0; i < length; i++ ) 
			sb.append( textnumber.charAt( random.nextInt(textnumber.length()) ) );
		return sb.toString();

	}

	public static String generateRandomHBnumber() {
		
		return generateRandomString(3)+generateRandomNumericString(3);
	}


	

}
