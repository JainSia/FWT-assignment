package com.yash.moviebookingsystem.daoimpl;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.util.JSONUtil;
import com.yash.moviebookingsystem.util.MBSFileUtility;

public class ScreenDAOImpl implements ScreenDAO {

	private static Logger logger=Logger.getLogger(ScreenDAOImpl.class);
	private MBSFileUtility mbsFileUtility=new MBSFileUtility();

	@Override
	public int add(Screen screen) {
		int result=0;
		String data=JSONUtil.convertObjectToJSONString(screen);
		try {
			mbsFileUtility.writeContentInFile("src/main/resources/ScreenJSON.json",data);
			result++;
		} catch (IOException e) {
			logger.error("Error Occured in DAO in adding screen");
		}
		return result;
	}

	@Override
	public String getScreenByName(String screenName) {
		String json=mbsFileUtility.readFile("src/main/resources/ScreenJSON.json",screenName);
		return null;
	}

	@Override
	public List<Screen> getAllScreen() {
		// TODO Auto-generated method stub
		return null;
	}

}
