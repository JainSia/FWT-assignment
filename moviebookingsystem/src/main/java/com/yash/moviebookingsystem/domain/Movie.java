package com.yash.moviebookingsystem.domain;

import java.sql.Time;
import java.util.List;

import com.yash.moviebookingsystem.enumeration.Status;

public class Movie {

	private long id;
	private String movieName;
	private Time duration;
	private String production;
	private Status status;
	private List<String> actors;
	
	public Movie(long id, String movieName, Time duration, String production, List<String> actors, Status status) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.duration = duration;
		this.production = production;
		this.setStatus(status);
		this.actors = actors;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public String getProduction() {
		return production;
	}
	public void setProduction(String production) {
		this.production = production;
	}
	public List<String> getActors() {
		return actors;
	}
	
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
