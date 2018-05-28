package com.yash.moviebookingsystem.serviceimpl;

import java.sql.Time;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.domain.Movie;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.EmptyObjectException;
import com.yash.moviebookingsystem.service.MovieService;

/**
 * this class will perform all the service related tak and validation
 * 
 * @author saloni.jain
 *
 */
public class MovieServiceImpl implements MovieService {

	private static Logger logger = Logger.getLogger(MovieServiceImpl.class);
	private MovieDAO movieDAO;

	public MovieServiceImpl(MovieDAO movieDAO) {
		this.movieDAO = movieDAO;
	}

	/**
	 * this method will add the movie and perform all the validation
	 * 
	 * @param movie
	 *            is the movie object that has to be added
	 * @return rowAffected is the intger value 1 if movie is added otherwise 0
	 * @throws EmptyObjectException 
	 */
	@Override
	public int add(Movie movie, String screenName) throws EmptyFieldException, EmptyObjectException {
		if (movie == null) {
			logger.error("Movie cannot be null");
			throw new NullPointerException("Movie cannot be null");
		}
		if (movie.getId() < 0 || movie.getMovieName() == "" || movie.getDuration() == Time.valueOf("00:00:00")
				|| movie.getProduction() == "" || screenName == "") {
			logger.error("Movie fields cannot be empty");
			throw new EmptyFieldException("Movie fields cannot be empty");
		}
		logger.info("movie service add method has been called");
		return movieDAO.insert(movie, screenName);
	}

}
