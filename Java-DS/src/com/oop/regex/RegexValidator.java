package com.oop.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator {

	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static void main(String[] args) {
		
		System.out.println(emailValidator("pranjalk@gmail.com"));
		System.out.println(emailValidator("pranjalk@mail.co.im"));
		System.out.println(emailValidator("pranjalk$gmail.com"));
		
	}
	
	public static boolean emailValidator(String emailString){
		
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(emailString);
		
		return matcher.matches();
		
	}
	
}
