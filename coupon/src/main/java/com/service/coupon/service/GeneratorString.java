package com.service.coupon.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import org.springframework.stereotype.Service;



@Service
public class GeneratorString {
	 	
	
	 public String idGenerate() throws NoSuchAlgorithmException {
			String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String randomString = "";

			Random rand = new Random();
			int length = rand.nextInt(15);
			char[] text = new char[length];
			for (int i = 0; i < length; i++) {
				text[i] = input.charAt(rand.nextInt(input.length()));
			}
			for (int i = 0; i < text.length; i++) {

				randomString += text[i];
			}
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			
			System.out.println("++++++++++++"+randomString);
			return randomString;
		
			//sendSimpleEmail("embedded8011@gmail.com", randomString, "Find couponid below");

		}
	
	
}

