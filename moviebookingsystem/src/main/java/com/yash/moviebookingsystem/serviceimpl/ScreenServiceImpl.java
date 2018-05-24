package com.yash.moviebookingsystem.serviceimpl;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.ScreenAlreadyExistException;
import com.yash.moviebookingsystem.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {

	private ScreenDAO screenDAO;
	
	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO=screenDAO;
	}

	@Override
	public int add(Screen screen) throws EmptyFieldException, ScreenAlreadyExistException {
		int rowAffected=0;
		if(screen==null) {
			throw new NullPointerException("Screen cannot be null");
		}
		if(screen.getScreenName()=="" || screen.getId()<0) {
			throw new EmptyFieldException("Screen name/id cannot be empty");
		}
		if(screenDAO.getScreenByName(screen.getScreenName())=="exist") {
			throw new ScreenAlreadyExistException("Screen already exception");
		}
		screenDAO.add(screen);
		rowAffected++;
		return rowAffected;
	}

}
