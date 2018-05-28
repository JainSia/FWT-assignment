package com.yash.moviebookingsystem.exception;

@SuppressWarnings("serial")
public class FileNameNotGivenException extends Exception {

	public FileNameNotGivenException(String errMessage) {
		super(errMessage);
	}
}
