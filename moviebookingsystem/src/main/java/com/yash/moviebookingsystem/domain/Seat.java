package com.yash.moviebookingsystem.domain;

import com.yash.moviebookingsystem.enumeration.Status;

public class Seat {
	private int id;
	private Status status;
	private Ticket ticket;
	
	
	public Seat(int id, Status status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "Seat [id=" + id + ", status=" + status + ", ticket=" + ticket + ", getId()=" + getId() + ", isStatus()="
				+ getStatus() + ", getTicket()=" + getTicket() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
