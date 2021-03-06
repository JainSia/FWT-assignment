package com.yash.moviebookingsystem.domain;

import java.util.List;

public class Screen {

	private int id;
	private String screenName;
	private Movie movie;
	private List<Row> rows;
	
	
	public Screen(int id, String screenName) {
		this.id = id;
		this.screenName = screenName;
	}

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public List<Row> getRows() {
		return rows;
	}
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", screenName=" + screenName + ", movie=" + movie + ", rows=" + rows + "]";
	}
	
}
