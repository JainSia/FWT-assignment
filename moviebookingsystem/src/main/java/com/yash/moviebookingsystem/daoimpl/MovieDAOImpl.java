package com.yash.moviebookingsystem.daoimpl;



import java.util.List;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.domain.Movie;
import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.util.JSONUtil;
import com.yash.moviebookingsystem.util.MBSFileUtility;

public class MovieDAOImpl implements MovieDAO {

	private MBSFileUtility mbsFileUtility=new MBSFileUtility();
	@Override
	public int insert(Movie movie, String screenName) {
		int result=0;
		String data=mbsFileUtility.readFileReturnString("src/main/resources/ScreenJSON.json");
		List<Screen> screen=JSONUtil.ConvertjsonToObject(data);
		for (Screen screenobject : screen) {
			if(screenobject.getScreenName()==screenName){
				screenobject.setMovie(movie);
				result++;
			}
		}
		return result;
	}

}
