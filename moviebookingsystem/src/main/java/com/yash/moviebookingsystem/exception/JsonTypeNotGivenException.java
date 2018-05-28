package com.yash.moviebookingsystem.exception;

@SuppressWarnings("serial")
public class JsonTypeNotGivenException extends Exception {

	public JsonTypeNotGivenException(String errMsg) {
		super(errMsg);
	}
}
