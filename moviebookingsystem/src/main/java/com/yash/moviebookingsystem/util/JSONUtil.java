package com.yash.moviebookingsystem.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingsystem.domain.Screen;

/**
 * this class will convert Object to JSON and JSON string to Object.
 * 
 * @author saloni.jain
 *
 */
public class JSONUtil {

	private static List<Screen> listOfScreenObject = new ArrayList<>();
	private static List<Screen> listOfJsonToString = new ArrayList<>();
	private static Gson gson = new Gson();
	private static Type type = new TypeToken<List<Screen>>() {
	}.getType();
	private static String json;

	/**
	 * this will take the screen object and convert it into json type screen
	 * 
	 * @param screen
	 *            object
	 * @return JSON form of string
	 */
	public static String convertObjectToJSONString(Screen screen) {
		listOfScreenObject.add(screen);
		json = gson.toJson(listOfScreenObject, type);
		return json;
	}

	/**
	 * this will convert JSON string to object
	 * 
	 */
	public static List<Screen> ConvertjsonToObject(String data) {
		Gson gson = new Gson();
		Type type = new TypeToken<List<Screen>>() {
		}.getType();
		json = gson.toJson(data, type);
		List<Screen> fromJson = gson.fromJson(json, type);
		for (Screen screen : fromJson) {
			System.out.println(screen);
		}
		return fromJson;
	}

}
