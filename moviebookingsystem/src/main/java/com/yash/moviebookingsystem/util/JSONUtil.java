package com.yash.moviebookingsystem.util;

import java.lang.reflect.Type;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.yash.moviebookingsystem.exception.EmptyObjectException;
import com.yash.moviebookingsystem.exception.JsonTextNotGivenException;
import com.yash.moviebookingsystem.exception.JsonTypeNotGivenException;

/**
 * this class will convert Object to JSON and JSON string to Object.
 * 
 * @author saloni.jain
 *
 */
public class JSONUtil {

	private static Logger logger = Logger.getLogger("JSONUtil.class");

	/**
	 * this method will convert object into json
	 * 
	 * @param object
	 * @return
	 * @throws EmptyObjectException
	 */
	public static String convertObjectToJSON(Object object) throws EmptyObjectException {
		logger.info("Converting  Object To JSON");
		isObjectGiven(object);
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	/**
	 * this will check the object is null or not
	 * 
	 * @param object
	 * @throws EmptyObjectException
	 */
	private static void isObjectGiven(Object object) throws EmptyObjectException {
		if (object == null)
			throw new EmptyObjectException("An object should be given");
	}

	/**
	 * this will convert the json object to compatible type
	 * 
	 * @param jsonText
	 * @param typeOfObject
	 * @return
	 * @throws JsonTextNotGivenException
	 * @throws JsonTypeNotGivenException
	 */
	public static <T> T convertJSONToObject(String jsonText, Type typeOfObject)
			throws JsonTextNotGivenException, JsonTypeNotGivenException {
		logger.info("converting JSON To Object");
		isJSONTextGiven(jsonText);
		isJSONTypeOfObjectGiven(typeOfObject);
		Gson gson = new Gson();
		return gson.fromJson(jsonText, typeOfObject);
	}

	/**
	 * this is the helper method that will check the type of given object
	 * 
	 * @param typeOfObject
	 * @throws JsonTypeNotGivenException
	 */
	private static void isJSONTypeOfObjectGiven(Type typeOfObject) throws JsonTypeNotGivenException {
		if (typeOfObject == null)
			throw new JsonTypeNotGivenException("Type of object should be specified");
	}

	/**
	 * this is the helper method that will check the type of given object
	 * 
	 * @param jsonText
	 * @throws JsonTextNotGivenException
	 */

	private static void isJSONTextGiven(String jsonText) throws JsonTextNotGivenException {
		if (jsonText == null || jsonText.isEmpty())
			throw new JsonTextNotGivenException("JSOn should be given");
	}

}
