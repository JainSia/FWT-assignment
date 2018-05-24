package com.yash.moviebookingsystem.util;

import java.util.Scanner;

public class MBSMenu {

	private MBSFileReader mbsFileReader=new MBSFileReader();
	private Scanner scanner;
	/**
	 * 
	 */
	public void getMenu(){
	scanner=new Scanner(System.in);
	String choice;
	int menuChoice;
	do {
		mbsFileReader.readFile("MainMenu.txt");
		menuChoice = scanner.nextInt();
		switch (menuChoice) {
		case 1:
			System.out.println("Enter Screen : ");
			String screenName=scanner.next();
			
			break;

		case 2:
			System.out.println("Enter Screen on which you want to add movie : ");
			String screen=scanner.nextLine();
			break;
			
		default:
			break;
		}
		System.out.println("Do you want to continue..?");
		choice=scanner.next();
	} while (choice.equalsIgnoreCase("Yes"));
	}
}
