package com.yash.moviebookingsystem.main;

import java.io.IOException;

import com.yash.moviebookingsystem.util.MBSMenu;

public class Startup {

	public static void main(String[] args) throws IOException {
		MBSMenu mbsMenu=new MBSMenu();
		mbsMenu.getMenu();
		}
}
