package com.yash.moviebookingsystem.serviceimpl;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.ScreenAlreadyExistException;
import com.yash.moviebookingsystem.service.ScreenService;

/**
 * this class will perform all the business validation related task
 * 
 * @author saloni.jain
 *
 */
public class ScreenServiceImpl implements ScreenService {

	private static Logger logger = Logger.getLogger(ScreenServiceImpl.class);

	private ScreenDAO screenDAO;

	public ScreenServiceImpl(ScreenDAO screenDAO) {
		this.screenDAO = screenDAO;
	}

	/**
	 * this will add the screen in the file and perform all the validation
	 * 
	 * @param screen
	 *            object that will be added the object
	 * @return rowAffected is the integer value return 1 when screen is added
	 *         otherwise 0
	 * @throws IOException 
	 */
	@Override
	public int add(Screen screen) throws EmptyFieldException, ScreenAlreadyExistException, IOException {
		int rowAffected = 0;
		isScreenNull(screen);
		isScreenFieldEmpty(screen);
//		if (screenDAO.getScreenByName(screen.getScreenName()) == "exists" || screenDAO.getAllScreen().size() >= 3) {
//			logger.error("Screen already exception");
//			throw new ScreenAlreadyExistException("Screen already exception");
//		}
		logger.info(" Screen service add has been called..");
		screenDAO.add(screen);
		rowAffected++;
		return rowAffected;
	}

	private void isScreenFieldEmpty(Screen screen) throws EmptyFieldException {
		if (screen.getScreenName() == "" || screen.getId() < 0) {
			logger.error("Screen name/id cannot be empty");
			throw new EmptyFieldException("Screen name/id cannot be empty");
		}
	}

	private void isScreenNull(Screen screen) {
		if (screen == null) {
			logger.error("Screen cannot be null");
			throw new NullPointerException("Screen cannot be null");
		}
	}

}
