package com.yash.moviebookingsystem.exception;

@SuppressWarnings("serial")
public class EmptyFileException extends RuntimeException {

	public EmptyFileException(String message) {
		super(message);
	}
}
