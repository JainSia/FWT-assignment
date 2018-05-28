package com.yash.moviebookingsystem.service;

import com.yash.moviebookingsystem.domain.Row;
import com.yash.moviebookingsystem.exception.EmptyFieldException;

public interface SeatingArrangementService {
	
	public int arrangeSeatsForScreen(Row row) throws EmptyFieldException;
	

}
