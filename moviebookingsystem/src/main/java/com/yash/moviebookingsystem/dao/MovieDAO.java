package com.yash.moviebookingsystem.dao;

import com.yash.moviebookingsystem.domain.Movie;

public interface MovieDAO {

	public int insert(Movie movie, String screenName);

}
