package com.oop.fileOperations;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;




/**
 * Java IO packages: java.io -- stream IO , java.nio - new IO
 * Stream IO -- Byte Stream (images), Character stream (text)
 * Files -- Binary or Text
 * Computer uses Hexadecimal to represent data bytes
 * encoding - is an algorithms which maps binary/char to hex
 * encoding schemes - ASCII, UTF-16, UTF-32
 * Character set  -ASCII, UTF(BMP + Non BMP)
 * Java uses UTF-16 format. Web mostly uses UTF-8
 * Endianness: Big endian - MSB stored at lowest memory address, commonly used
 * Low endian - MSB stored at highest memory address
 * Byte Order Mark (BOM): added at the start of data stream to represent its Endianness
 * 	BE -- FEFF
 * 	LE -- FFFE
 */

public class EncodingScheme {

	public static void applyEncoding() {
		System.out.println("\nInside applyEncoding ...");
		//System.out.println("Default Character Encoding: " + System.getProperty("file.encoding"));
		
		// Ensure Eclipse property is set as UTF8		
		printEncodingDetails("luke");
		printEncodingDetails("€"); // Euro (Reference: http://stackoverflow.com/questions/34922333/how-does-java-fit-a-3-byte-unicode-character-into-a-char-type)
		printEncodingDetails("\u1F602"); // Non-BMP Unicode Code Point ~ Tears of Joy Emoji (one of Smiley graphic symbol)      
	}	
	private static void printEncodingDetails(String symbol) {
		System.out.println("\nSymbol: " + symbol);
		try {
			System.out.println("ASCII: " + Arrays.toString(symbol.getBytes("US-ASCII")));
			System.out.println("ISO-8859-1: " + Arrays.toString(symbol.getBytes("ISO-8859-1")));
			System.out.println("UTF-8: " + Arrays.toString(symbol.getBytes("UTF-8")));
			System.out.println("UTF-16: " + Arrays.toString(symbol.getBytes("UTF-16")));
			System.out.println("UTF-16 BE: " + Arrays.toString(symbol.getBytes("UTF-16BE")));
			System.out.println("UTF-16 LE: " + Arrays.toString(symbol.getBytes("UTF-16LE")));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}		
	}

	public static void main(String[] args) {
		applyEncoding();
	}
}
