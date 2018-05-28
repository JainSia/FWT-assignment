package com.yash.moviebookingsystem.serviceimpl;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.yash.moviebookingsystem.dao.SeatingArrangementDAO;
import com.yash.moviebookingsystem.domain.Row;
import com.yash.moviebookingsystem.domain.Seat;
import com.yash.moviebookingsystem.enumeration.Category;
import com.yash.moviebookingsystem.enumeration.Status;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.service.SeatingArrangementService;

public class SeatingArrangementImplTest {

	@Mock
	private SeatingArrangementDAO seatingArrangementDAO;
	
	private SeatingArrangementService seatingArrangementService; 
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		seatingArrangementService=new SeatingArrangementImpl(seatingArrangementDAO);
	}
	
	@Test(expected=NullPointerException.class)
	public void arrangeSeatsForScreen_NullRowsObjectGiven_throwNullPointerException() throws EmptyFieldException {
		Row row=null;
		seatingArrangementService.arrangeSeatsForScreen(row);
	}
	
	@Test(expected=EmptyFieldException.class)
	public void arrangeSeatsForScreen_EmptyFieldRowObjectGiven_throwEmptyFieldException() throws EmptyFieldException {
		Seat seat=null;
		Row row=new Row(1,seat,Category.GOLD);
		seatingArrangementService.arrangeSeatsForScreen(row);
	}

	@Test
	public void arrangeSeatsForScreen_RowsObjectGiven_ReturnOne() throws EmptyFieldException {
		when(seatingArrangementDAO.arrangeSeat(any(Row.class))).thenReturn(1);
		Seat seat=new Seat(1,Status.NOTBOOKED);
		Row row=new Row(1,seat,Category.GOLD);
		seatingArrangementService.arrangeSeatsForScreen(row);
	}
}
