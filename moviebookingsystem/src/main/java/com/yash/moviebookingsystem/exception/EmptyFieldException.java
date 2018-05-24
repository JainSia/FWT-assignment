package com.yash.moviebookingsystem.exception;

@SuppressWarnings("serial")
public class EmptyFieldException extends Exception {

	public EmptyFieldException(String errMsg) {
		super(errMsg);
	}

}
