package com.yash.moviebookingsystem.daoimpl;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.reflect.TypeToken;
import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.exception.EmptyObjectException;
import com.yash.moviebookingsystem.exception.FileNameNotGivenException;
import com.yash.moviebookingsystem.exception.JsonTextNotGivenException;
import com.yash.moviebookingsystem.util.JSONUtil;
import com.yash.moviebookingsystem.util.MBSFileUtility;

public class ScreenDAOImpl implements ScreenDAO {

	private static Logger logger = Logger.getLogger(ScreenDAOImpl.class);
	private MBSFileUtility mbsFileUtility = new MBSFileUtility();

	@Override
	public int add(Screen screen) throws EmptyObjectException {
		int result = 0;
		String data = JSONUtil.convertObjectToJSON(screen);
		try {
			mbsFileUtility.writeInFile("ScreenJSON", data);
			result++;
		} catch (JsonTextNotGivenException e) {
			logger.error("Error in creating JSON");
		} catch (FileNameNotGivenException e) {
			logger.error("Wrong file name");
		}
		return result;
	}

	@Override
	public Screen getScreenByName(String screenName) {
		Screen screen=null;
		List<Screen> screenList=mbsFileUtility.readFile("ScreenJSON", new TypeToken<Screen>(){}.getType());
		for (Screen screenToFind : screenList) {
			if(screenToFind.getScreenName().equalsIgnoreCase(screenName))
				return screenToFind;
		}
		return screen;
	}

	@Override
	public List<Screen> getAllScreen() {
		return null;
	}

}
