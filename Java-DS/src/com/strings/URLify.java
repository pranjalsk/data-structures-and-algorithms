package com.strings;

/**
 * Write a method to replace all the spaces in a string with ‘%20’. You may
 * assume that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the “true” length of the string.
 * 
 * Examples:
 * 
 * Input : "Mr John Smith", 13 Output : Mr%20John%20Smith
 * 
 * Input : "Mr John Smith   ", 13 Output : Mr%20John%20Smith
 * 
 */
public class URLify {
	
	public static void main(String[] args) {
		 char str[] = "Mr John Smith".toCharArray();
		 replaceSpaces(str);
		 
	}

	public static void replaceSpaces(char[] str) {

		int len = str.length;
		int spaceCount = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}

		
		int newLen = len + spaceCount * 2;
		char [] newStr = new char[newLen];

		for (int i = len - 1; i >= 0; i--) {

			if (str[i] == ' ') {
				newStr[--newLen] = '0';
				newStr[--newLen] = '2';
				newStr[--newLen] = '%';
			} else {
				newStr[--newLen] = str[i];
			}

		}
		
		for(char c : newStr){
			System.out.print(c);
		}
	}

}
