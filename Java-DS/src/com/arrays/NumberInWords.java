package com.arrays;

public class NumberInWords {

	final static String[] digits = { "", "one", "two", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ",
			"ten ", "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ",
			"nineteen " };

	final static String[] tens = { "", "", "twenty", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ",
			"ninety " };

	
	//for single digit or double digit
	private String numToWords(int num, String s){
		
		String str = "";
		if(num > 19){
			String digitPlace = digits[num % 10];
			String tensPlace = tens[num / 10];
			
			str = str + tensPlace + digitPlace;
		}
		else{
			str = str + digits[num];
		}
		
		//n is non zero
		if(num!=0)
			str = str + s;
		
		return str;
	}
	
}

