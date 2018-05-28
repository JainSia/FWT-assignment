package com.yash.moviebookingsystem.domain;

import com.yash.moviebookingsystem.enumeration.Category;

public class Row {
	private long id;
	private Seat seat;
	private Category category;
	public long getId() {
		return id;
	}
	public Row(long id, Seat seat, Category category) {
		super();
		this.id = id;
		this.seat = seat;
		this.category = category;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Row [id=" + id + ", seat=" + seat + ", category=" + category + ", getId()=" + getId() + ", getSeat()="
				+ getSeat() + ", getCategory()=" + getCategory() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
