package com.yash.moviebookingsystem.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.yash.moviebookingsystem.exception.EmptyFileException;
import com.yash.moviebookingsystem.exception.FileNotExistException;

public class MBSFileReader {

	private File file;
	
	public void readFile(String fileName) {
		 file=getFile(fileName);
		 String contentOfFile;
		 BufferedReader bufferedReader;
		try {
			bufferedReader=new BufferedReader(new FileReader(file));
			contentOfFile=bufferedReader.readLine();
			isFileEmpty(bufferedReader, contentOfFile);
			contentOfFile = printContentOfFile(bufferedReader, contentOfFile);
			bufferedReader.close();
		}catch(Exception exception){
			throw new EmptyFileException("File is Empty");
		}
	}
	
	
	private File getFile(String fileName){
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			file = new File(classLoader.getResource(fileName).getFile());
			return file;
		} catch (Exception exception) {
			throw new FileNotExistException("File does not exist");
		}
	  }

	

	private String printContentOfFile(BufferedReader bufferedReader, String contentOfFile) throws IOException {
		while(contentOfFile!=null){
			System.out.println(contentOfFile);
			contentOfFile=bufferedReader.readLine();
		}
		return contentOfFile;
	}

	private void isFileEmpty(BufferedReader bufferedReader, String contentOfFile) throws IOException {
		if(contentOfFile.isEmpty()){
			bufferedReader.close();
			throw new EmptyFileException("File is Empty");
		}
	}
		
	

}
