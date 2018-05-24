package com.yash.moviebookingsystem.exception;

@SuppressWarnings("serial")
public class FileNotExistException extends RuntimeException {

	public FileNotExistException(String message) {
		super(message);
	}
}
