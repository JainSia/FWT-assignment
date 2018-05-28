package com.yash.moviebookingsystem.dao;

import com.yash.moviebookingsystem.domain.Movie;
import com.yash.moviebookingsystem.exception.EmptyObjectException;

public interface MovieDAO {

	public int insert(Movie movie, String screenName) throws EmptyObjectException;

}
