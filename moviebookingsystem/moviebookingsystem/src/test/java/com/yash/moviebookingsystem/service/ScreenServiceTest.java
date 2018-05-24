package com.yash.moviebookingsystem.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.serviceimpl.ScreenServiceImpl;

public class ScreenServiceTest {

	@Mock
	private ScreenDAO screenDAO;

	private ScreenService screenService;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnTrue() {
		when(screenDAO.add(any(Screen.class))).thenReturn(true);
		Screen screen=new Screen();
		screenService=new ScreenServiceImpl(screenDAO);
		assertThat(screenService.add(screen), is(notNullValue()));

	}

}
