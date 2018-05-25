package com.yash.moviebookingsystem.serviceimpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.domain.Movie;
import com.yash.moviebookingsystem.enumeration.Status;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.service.MovieService;

public class MovieServiceImplTest {

	@Mock
	private MovieDAO movieDAO;
	private MovieService movieService;
	private String screenName = "audi-1";
	private List<String> actors = new ArrayList<>();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		movieService = new MovieServiceImpl(movieDAO);
		actors.add("aliabhatt");
	}

	@Test(expected = NullPointerException.class)
	public void addMovie_MovieNullObjectGiven_throwNullPointerException() throws EmptyFieldException {

		Movie movie = null;
		movieService.add(movie, screenName);
	}

	@Test(expected = EmptyFieldException.class)
	public void addMovie_EmptyMovieFieldsGiven_throwEmptyFieldException() throws EmptyFieldException {

		Movie movie = new Movie(1, "Razzi", Time.valueOf("02:00:00"), "", actors, Status.ONSCREEN);
		movieService.add(movie, screenName);
	}

	@Test(expected = EmptyFieldException.class)
	public void addMovie_EmptyScreenNameGiven_throwEmptyFieldException() throws EmptyFieldException {
		String screenName = "";
		Movie movie = new Movie(1, "Raazi", Time.valueOf("02:00:00"), "SRK", actors, Status.ONSCREEN);
		movieService.add(movie, screenName);
	}

	@Test
	public void addMovie_MovieObjectGiven_shouldReturnOne() throws EmptyFieldException {
		Movie movie = new Movie(1, "Razzi", Time.valueOf("02:00:00"), "SRK", actors, Status.ONSCREEN);
		when(movieDAO.insert(movie, screenName)).thenReturn(1);
		int rowAffected = movieService.add(movie, screenName);
		assertEquals(1, rowAffected);
	}

}
