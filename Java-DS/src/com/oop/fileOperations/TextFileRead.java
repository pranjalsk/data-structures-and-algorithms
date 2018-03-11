package com.oop.fileOperations;

import java.io.*;
import java.util.ArrayList;

public class TextFileRead {

	private static final String FILENAME = "C:\\Users\\pranj\\Downloads\\data-structures-and-algorithms\\Java-DS\\sample.txt";

	public static void main(String[] args) {

		readFileTry();

		System.out.println("----------");
		
		readFileTryWithResources();
		System.out.println("----------");
		
		readFileInputStream();
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
		
		ArrayList<String> strArr = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
			String currLine;
			while((currLine = br.readLine())!=null){
				strArr.add(currLine);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(strArr);
		
	}
	
	//using input stream
	@SuppressWarnings("deprecation")
	public static void readFileInputStream(){
		
		File file = new File(FILENAME);
		StringBuilder sb = new StringBuilder();
		try {
			
			DataInputStream br = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			String currLine;
			while ((currLine = br.readLine()) != null) {
				sb.append(currLine);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(sb.toString());
		
	}
	
}
