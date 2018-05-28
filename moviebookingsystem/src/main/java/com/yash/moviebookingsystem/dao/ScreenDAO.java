package com.yash.moviebookingsystem.dao;

import java.io.IOException;
import java.util.List;

import com.yash.moviebookingsystem.domain.Screen;

public interface ScreenDAO {

	public int add(Screen screen) throws IOException;

	public String getScreenByName(String any);

	public List<Screen> getAllScreen();

}
