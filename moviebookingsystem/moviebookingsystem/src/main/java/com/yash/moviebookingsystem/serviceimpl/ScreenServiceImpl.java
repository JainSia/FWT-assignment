package com.yash.moviebookingsystem.serviceimpl;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.service.ScreenService;

public class ScreenServiceImpl implements ScreenService {

	private ScreenDAO screenDAO;
	
	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO=screenDAO;
	}

	@Override
	public boolean add(Screen screen) {
		// TODO Auto-generated method stub
		return false;
	}

}
