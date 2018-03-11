package com.oop.fileOperations;

import java.io.*;

public class StreamFileIO {

	private static final String FILENAME = "C:\\Users\\pranj\\Downloads\\data-structures-and-algorithms\\Java-DS\\sample.txt";

	public static void main(String[] args) {

		readFileTry();

		System.out.println("----------");
		
		readFileTryWithResources();
		
	}

	public static void readFileTry() {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		try {
			br = new BufferedReader(new FileReader(FILENAME));

			String currLine;

			while ((currLine = br.readLine()) != null) {
				sb.append(currLine);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		System.out.println(sb.toString());

	}

	//Try-with-resources
	public static void readFileTryWithResources(){
		
		StringBuilder sb = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
			String currLine;
			while((currLine = br.readLine())!=null){
				sb.append(currLine);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(sb.toString());
		
	}
	
}
