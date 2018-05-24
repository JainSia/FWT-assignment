package com.yash.moviebookingsystem.dao;

import com.yash.moviebookingsystem.domain.Screen;

public interface ScreenDAO {

	public int add(Screen screen);

	public String getScreenByName(String any);

}
