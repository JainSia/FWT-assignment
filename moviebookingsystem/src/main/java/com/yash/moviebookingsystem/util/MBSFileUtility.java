package com.yash.moviebookingsystem.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.exception.FileNameNotGivenException;
import com.yash.moviebookingsystem.exception.FileNotExistException;
import com.yash.moviebookingsystem.exception.JsonTextNotGivenException;

public class MBSFileUtility {

	private Logger logger = Logger.getLogger("FileUtil.class");

	
	
	/**
	 * this method will write the data provided in file
	 * 
	 * @param filepath
	 *            is the path of file in which you want to write the data
	 * @param data
	 *            is what you want to be written in file
	 * @throws JsonTextNotGivenException
	 * @throws FileNameNotGivenException
	 */
	public boolean writeInFile(String fileName, String jsonText) throws JsonTextNotGivenException, FileNameNotGivenException {
		logger.info("Writing in file : "+fileName);
		if(jsonText == null || jsonText.isEmpty())
			throw new JsonTextNotGivenException("Give Json text to write in the file");
		if(fileName == null || fileName.isEmpty())
			throw new FileNameNotGivenException("Give a file name");
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter("src/main/resources/"+fileName+".json",true));
			fileWriter.append(jsonText);
			fileWriter.newLine();
			fileWriter.close();
		} catch (IOException e) {
			logger.error("Error in writing file");
		}
		
		return true;
	}
	
	/**
	 * this will read the file whose name is given
	 * 
	 * @param fileName name of file
	 * @param type is type of object that will save in list
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> readFile(String fileName, Type type) {
		logger.info("Reading into file :"+fileName);
		List<T> objects = new ArrayList<T>();
		File fileToRead = getFile(fileName);
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(fileToRead));
			
			String currentline;
			
			while ((currentline = fileReader.readLine()) != null) {
				objects.add((T) JSONUtil.convertJSONToObject(currentline, type));
			}
			
			fileReader.close();
			
		} catch (Exception e) {
			logger.error("Error in reading file");
		}
		return objects;
	}
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	private File getFile(String fileName){
		logger.info("searching file :"+fileName);
		ClassLoader classLoader = getClass().getClassLoader();
		try {
			File file = new File(classLoader.getResource(fileName).getFile());
			return file;
		} catch (Exception exception) {
			throw new FileNotExistException("File does not exist");
		}
	  }

	/**
	 * this will help to read file that contains menu
	 * 
	 * @param fileName
	 */
	public void readMenu(String fileName) {
		logger.info("Reading menu :"+fileName);
		File fileToRead = getFile(fileName);
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(fileToRead));
			
			String currentline;
			
			while ((currentline = fileReader.readLine()) != null) {
				System.out.println(currentline);
			}
			
			fileReader.close();
			
		} catch (Exception e) {
			logger.error("Error in reading menu file");
		}
	}


	
}
