package com.yash.moviebookingsystem.util;

import org.junit.Before;
import org.junit.Test;

import com.yash.moviebookingsystem.exception.EmptyFileException;
import com.yash.moviebookingsystem.exception.FileNotExistException;

public class MBSFileUtilityTest {

	private MBSFileUtility mbsFileUtility;

	@Before
	public void setUp() {
		mbsFileUtility = new MBSFileUtility();
	}

	@Test(expected = FileNotExistException.class)
	public void throwFileNotExistException_ifFileDoesnotExist() {
		mbsFileUtility.getFile("FileMenu.txt");
	}

	@Test(expected = EmptyFileException.class)
	public void throwEmptyFileException_ifFileIsEmpty() {
		mbsFileUtility.readFile("Menu.txt");
	}

	@Test
	public void readFile_fileNameGiven_printMenu() {
		mbsFileUtility.readFile("MainMenu.txt");
	}

}
