package com.yash.moviebookingsystem.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.EmptyObjectException;
import com.yash.moviebookingsystem.exception.ScreenAlreadyExistException;
import com.yash.moviebookingsystem.service.ScreenService;

public class ScreenServiceImplTest {

	@Mock
	private ScreenDAO screenDAO;

	private ScreenService screenService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		screenService = new ScreenServiceImpl(screenDAO);
	}

	@Test(expected = NullPointerException.class)
	public void addScreen_NullObjectGiven_throwObjectNullabitityException()
			throws EmptyFieldException, ScreenAlreadyExistException, IOException, EmptyObjectException {
		Screen screen = null;
		screenService.add(screen);

	}

	@Test(expected = EmptyFieldException.class)
	public void addScreen_EmptyFeildValueGiven_throwEmptyScreenException()
			throws EmptyFieldException, ScreenAlreadyExistException, IOException, EmptyObjectException {
		Screen screen = new Screen(1, "");
		screenService.add(screen);

	}

	@Test(expected = ScreenAlreadyExistException.class)
	public void addScreen_ScreenObjectGiven_IfScreenExist_throwScreenAlreadyExistException()
			throws EmptyFieldException, ScreenAlreadyExistException, IOException, EmptyObjectException {
		when(screenDAO.getScreenByName(any(String.class)))
				.thenThrow(new ScreenAlreadyExistException("Screen Already exists"));
		Screen screen = new Screen(1, "audi");
		screenService.add(screen);
	}

	@Test(expected = ScreenAlreadyExistException.class)
	public void addScreen_ScreenObjectGiven_whenAlreadyHaveMoreThanThreeScreen_throwExceedCapacityException()
			throws EmptyFieldException, ScreenAlreadyExistException, IOException, EmptyObjectException {
		Screen screen = new Screen(1, "audi");
		when(screenDAO.getAllScreen().size())
				.thenThrow(new ScreenAlreadyExistException("Screen already Exist exception"));
		screenService.add(screen);
	}

	@Test
	public void addScreen_ScreenObjectGiven_ShouldReturnOne() throws EmptyFieldException, ScreenAlreadyExistException, IOException, EmptyObjectException {
		when(screenDAO.add(any(Screen.class))).thenReturn(1);
		Screen screen = new Screen(1, "audi-1");
		int rowAffected = screenService.add(screen);
		assertEquals(1, rowAffected);

	}

}
