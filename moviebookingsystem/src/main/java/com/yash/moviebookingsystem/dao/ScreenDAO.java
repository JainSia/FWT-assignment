package com.yash.moviebookingsystem.dao;

import java.io.IOException;
import java.util.List;

import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.exception.EmptyObjectException;

public interface ScreenDAO {

	public int add(Screen screen) throws IOException, EmptyObjectException;

	public Screen getScreenByName(String any);

	public List<Screen> getAllScreen();

}
