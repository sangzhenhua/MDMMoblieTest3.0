package com.pekall.test.mdmui.util;

import java.util.Random;

public class RandomString {
	private static RandomString instance;
	public static RandomString getInstance(){
		if(instance == null){
			instance = new RandomString();
		}
		return instance;
	}
	
	public String getRandomDigitString(int length){
		String base = "0123456789";
		return getRandomString(base, length);
	}
	
	public String getRandomAlphabetString(int length){
		String base = "abcdefghigklmnopqrstuvwxyz";
		return getRandomString(base, length);
	}
	
	public String getRandomSpecialString(int length){
		String base = "!~#$%^&*()+_-=";
		return getRandomString(base, length);
	}
	
	private String getRandomString(String base,int length){  
	        Random random = new Random();     
	        StringBuffer sb = new StringBuffer();     
	        for (int i = 0; i < length; i++) {     
	            int number = random.nextInt(base.length());     
	            sb.append(base.charAt(number));     
	        }     
	        return sb.toString();          
	}
}
