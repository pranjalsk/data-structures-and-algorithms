package com.oop.tinyurl;

import java.util.HashMap;
import java.util.Map;

public class EncoderDecoder {

	private static final String HOST = "http://tinyurl.com/";

	private Map<Integer, String> map = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	int key = longUrl.hashCode();
    	map.put(key, longUrl);
    	return HOST+key;
    }

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		int key = Integer.parseInt(shortUrl.replace(HOST, ""));
		return map.get(key);
	}
}
