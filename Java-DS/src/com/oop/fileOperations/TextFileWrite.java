package com.oop.fileOperations;

import java.io.*;

public class TextFileWrite {

	private static final String FILEPATH = "C:\\Users\\pranj\\Downloads\\data-structures-and-algorithms\\Java-DS\\writesample.txt";

	public static void main(String[] args) {

		String content = "Last pic of Starman in Roadster en route to Mars Orbit and then the Asteroid Belt.";

		fileWriteTryResources(content);
		System.out.println("---");
		writeBufferedTryResources(content);

	}

	public static void fileWriteTryResources(String content) {

		File file = new File(FILEPATH);

		try (FileOutputStream fop = new FileOutputStream(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ------------- BufferedWriter
	public static void writeBufferedTryResources(String content) {

		//true means append content to end of file.
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILEPATH,true))) {

			bw.write(content);

			// no need to close it.
			// bw.close();
			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
