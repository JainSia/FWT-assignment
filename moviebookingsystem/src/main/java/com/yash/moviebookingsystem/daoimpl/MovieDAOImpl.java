package com.yash.moviebookingsystem.daoimpl;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.domain.Movie;
import com.yash.moviebookingsystem.exception.EmptyObjectException;
import com.yash.moviebookingsystem.exception.FileNameNotGivenException;
import com.yash.moviebookingsystem.exception.JsonTextNotGivenException;
import com.yash.moviebookingsystem.service.ScreenService;
import com.yash.moviebookingsystem.serviceimpl.ScreenServiceImpl;
import com.yash.moviebookingsystem.util.JSONUtil;
import com.yash.moviebookingsystem.util.MBSFileUtility;

public class MovieDAOImpl implements MovieDAO {

	private static Logger logger = Logger.getLogger(ScreenDAOImpl.class);
	private ScreenDAO screenDAO=new ScreenDAOImpl();
	private ScreenService screenService=new ScreenServiceImpl(screenDAO);
	private MBSFileUtility mbsFileUtility = new MBSFileUtility();

	@Override
	public int insert(Movie movie, String screenName) throws EmptyObjectException {
		int result = 0;
		movie.setScreenName(screenName);
		String data = JSONUtil.convertObjectToJSON(movie);
		try {
			mbsFileUtility.writeInFile("MovieJSON", data);
			result++;
		} catch (JsonTextNotGivenException e) {
			logger.error("Error in creating JSON");
		} catch (FileNameNotGivenException e) {
			logger.error("Wrong file name");
		}
		return result;
	}
}