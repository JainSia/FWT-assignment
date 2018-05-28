package com.yash.moviebookingsystem.service;

import com.yash.moviebookingsystem.domain.Movie;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.EmptyObjectException;

public interface MovieService {

	public int add(Movie movie, String screenName) throws EmptyFieldException, EmptyObjectException;
}
