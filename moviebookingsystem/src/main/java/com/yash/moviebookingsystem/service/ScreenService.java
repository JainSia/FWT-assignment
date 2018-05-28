package com.yash.moviebookingsystem.service;

import java.io.IOException;

import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.EmptyObjectException;
import com.yash.moviebookingsystem.exception.ScreenAlreadyExistException;

public interface ScreenService {

	public int add(Screen screen) throws EmptyFieldException, ScreenAlreadyExistException, EmptyObjectException, IOException;

}
