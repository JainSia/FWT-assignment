package com.yash.moviebookingsystem.util;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.daoimpl.MovieDAOImpl;
import com.yash.moviebookingsystem.daoimpl.ScreenDAOImpl;
import com.yash.moviebookingsystem.domain.Movie;
import com.yash.moviebookingsystem.domain.Screen;
import com.yash.moviebookingsystem.enumeration.Status;
import com.yash.moviebookingsystem.exception.EmptyFieldException;
import com.yash.moviebookingsystem.exception.EmptyObjectException;
import com.yash.moviebookingsystem.exception.ScreenAlreadyExistException;
import com.yash.moviebookingsystem.service.MovieService;
import com.yash.moviebookingsystem.service.ScreenService;
import com.yash.moviebookingsystem.serviceimpl.MovieServiceImpl;
import com.yash.moviebookingsystem.serviceimpl.ScreenServiceImpl;

public class MBSMenu {

	private MBSFileUtility mbsFileUtility = new MBSFileUtility();
	private ScreenDAO screenDAO=new ScreenDAOImpl();
	private ScreenService screenService=new ScreenServiceImpl(screenDAO);
	private MovieDAO movieDAO=new MovieDAOImpl();
	private MovieService movieService=new MovieServiceImpl(movieDAO);
	private Scanner scanner;

	/**
	 * this will show the main menu and perform all menu regarding operation
	 * @throws ScreenAlreadyExistException 
	 * @throws EmptyFieldException 
	 * @throws IOException 
	 * @throws EmptyObjectException 
	 */
	public void getMenu() throws EmptyFieldException, ScreenAlreadyExistException, IOException, EmptyObjectException {
		scanner = new Scanner(System.in);
		String choice;
		int menuChoice;
		do {
			mbsFileUtility.readMenu("MainMenu.txt");
			menuChoice = scanner.nextInt();
			switch (menuChoice) {
			case 1:
				screenToAdd();
				break;

			case 2:
				addMovieToScreen();
				break;

			default:
				break;
			}
			System.out.println("Do you want to continue..?");
			choice = scanner.next();
		} while (choice.equalsIgnoreCase("Yes"));
		
	}

	private void addMovieToScreen() throws EmptyFieldException, EmptyObjectException {
		List<String> listOfActors=new ArrayList<>();
		System.out.println("Enter Screen on which you want to add movie : ");
		String screen = scanner.next();
		scanner.nextLine();
		System.out.println("Enter movie id :");
		int id=scanner.nextInt();
		System.out.println("Enter Movie to add: ");
		String movieName = scanner.next();
		scanner.nextLine();
		System.out.println("Enter production : ");
		String production = scanner.next();
		scanner.nextLine();
		System.out.println("Enter number of actors you want to add : ");
		int number=scanner.nextInt();
		for(int i=1;i<=number;i++){
			System.out.println("Enter actors : ");
			String actor = scanner.next();
			scanner.nextLine();
			listOfActors.add(actor);
		}
		System.out.println("Enter duration of Movie(HH:MM:SS) : ");
		String durationOfMovie = scanner.nextLine();
		Time duration=Time.valueOf(durationOfMovie);
		Movie movie=new Movie(id, movieName, duration, production, listOfActors, Status.ONSCREEN);
		movieService.add(movie, screen);
	}

	private void screenToAdd() throws EmptyFieldException, ScreenAlreadyExistException, IOException, EmptyObjectException {
		System.out.println("Enter Screen id : ");
		int screenId = scanner.nextInt();
		System.out.println("Enter Screen : ");
		String screenName = scanner.next();
		Screen screenToAdd=new Screen(screenId, screenName);
		screenService.add(screenToAdd);
	}
}
