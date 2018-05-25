package com.yash.moviebookingsystem.domain;

public class Seat {
	private int id;
	private boolean status;
	private Ticket ticket;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
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
				+ isStatus() + ", getTicket()=" + getTicket() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
