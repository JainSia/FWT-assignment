package com.yash.moviebookingsystem.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.yash.moviebookingsystem.exception.EmptyFileException;
import com.yash.moviebookingsystem.exception.FileNotExistException;

public class MBSFileUtility {

	private File file;

	/**
	 * this will read the content of file
	 * 
	 * @param fileName
	 *            is the name of file whom content you want to read
	 */
	public void readFile(String fileName) {
		file = getFile(fileName);
		String contentOfFile;
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			contentOfFile = bufferedReader.readLine();
			isFileEmpty(bufferedReader, contentOfFile);
			printContentOfFile(bufferedReader, contentOfFile);
			bufferedReader.close();
		} catch (Exception exception) {
			throw new EmptyFileException("File is Empty");
		}
	}

	/**
	 * this will create the file according to file name
	 * 
	 * @param fileName
	 *            is the name of file you want to create
	 * @return file in which data will be stored
	 * @throws IOException
	 */
	public File createFile(String fileName) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			System.out.println(file.exists());
			file.createNewFile();
		}
		return file;
	}

	/**
	 * this method will write the data provided in file
	 * 
	 * @param filepath
	 *            is the path of file in which you want to write the data
	 * @param data
	 *            is what you want to be written in file
	 * @throws IOException
	 */
	public void writeContentInFile(String filepath, String data) throws IOException {

		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath, true));
		bufferedWriter.write(data);
		bufferedWriter.newLine();
		bufferedWriter.close();
	}

	/**
	 * this method which will help in getting the file from resources folder
	 * 
	 * @param fileName
	 *            is the name of file you want.
	 * @return the file or will throw an exception
	 */
	public File getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			file = new File(classLoader.getResource(fileName).getFile());
			return file;
		} catch (Exception exception) {
			throw new FileNotExistException("File does not exist");
		}
	}

	/**
	 * this will print the content of file
	 * 
	 * @param bufferedReader
	 *            will going to point the file which you wan to read
	 * @param contentOfFile
	 *            is the content you wan to print
	 * @throws IOException
	 */
	private void printContentOfFile(BufferedReader bufferedReader, String contentOfFile) throws IOException {
		while (contentOfFile != null) {
			System.out.println(contentOfFile);
			contentOfFile = bufferedReader.readLine();
		}
	}

	/**
	 * it will check the file that it is empty or not
	 * 
	 * @param bufferedReader
	 *            will going to point the file which you wan to check
	 * @param contentOfFile
	 *            is the content that you want to check
	 * @throws IOException
	 */
	private void isFileEmpty(BufferedReader bufferedReader, String contentOfFile) throws IOException {
		if (contentOfFile.isEmpty()) {
			bufferedReader.close();
			throw new EmptyFileException("File is Empty");
		}
	}
}
