package com.yash.moviebookingsystem.util;

import org.junit.Test;

import com.yash.moviebookingsystem.exception.EmptyFileException;
public class MBSMenuTest {
	
//	@Test(expected=FileNotExistException.class)
//	public void throwFileNotExistException_ifFileDoesnotExist() {
//		MBSMenu mbsMenu=new MBSMenu();
//		mbsMenu.getFile("FileMenu.txt");
//	}
	
	@Test(expected=EmptyFileException.class)	
	public void throwEmptyFileException_ifFileIsEmpty(){
		MBSFileReader mbsFileMenu=new MBSFileReader();
		mbsFileMenu.readFile("Menu.txt");
	}
	
	@Test
	public void readFile_fileNameGiven_printMenu(){
		MBSFileReader mbsFileMenu=new MBSFileReader();
		mbsFileMenu.readFile("MainMenu.txt");
	}

}
