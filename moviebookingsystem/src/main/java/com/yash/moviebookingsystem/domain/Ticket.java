package com.yash.moviebookingsystem.domain;

import com.yash.moviebookingsystem.enumeration.Category;

public class Ticket {

	private int id;
	private Category category;
	private String movieTitle;
	private double price;
	private double totalPrice;
	
	public Ticket(int id, Category category, String movieTitle, double price, double totalPrice) {
		super();
		this.id = id;
		this.category = category;
		this.movieTitle = movieTitle;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", category=" + category + ", movieTitle=" + movieTitle + ", price=" + price
				+ ", totalPrice=" + totalPrice + ", getId()=" + getId() + ", getCategory()=" + getCategory()
				+ ", getMovieTitle()=" + getMovieTitle() + ", getPrice()=" + getPrice() + ", getTotalPrice()="
				+ getTotalPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
}
