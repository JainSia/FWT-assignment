package com.yash.moviebookingsystem.serviceimpl;

import com.yash.moviebookingsystem.dao.SeatingArrangementDAO;
import com.yash.moviebookingsystem.domain.Row;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.service.SeatingArrangementService;

public class SeatingArrangementImpl implements SeatingArrangementService {

	
	private SeatingArrangementDAO seatingArrangementDAO;
	
	public SeatingArrangementImpl(SeatingArrangementDAO seatingArrangementDAO) {
		this.seatingArrangementDAO=seatingArrangementDAO;
	}

	@Override
	public int arrangeSeatsForScreen(Row row) throws EmptyFieldException {
		int result=0;
		if(row==null){
			throw new NullPointerException();
		}
		if(row.getId()<=0 || row.getSeat()==null){
			throw new EmptyFieldException("Feild can't be exist");
		}
		result=seatingArrangementDAO.arrangeSeat(row);
		result++;
		return result;
	}

}
