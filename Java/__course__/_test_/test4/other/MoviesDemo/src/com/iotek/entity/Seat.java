package com.iotek.entity;

public class Seat {
	private int id;
	private int row;
	private int colum;
	private int ticketId;
	private ShowHall hall;
	private int hallId;
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Seat(int id, int row, int colum, int ticketId, ShowHall hall) {
		super();
		this.id = id;
		this.row = row;
		this.colum = colum;
		this.ticketId = ticketId;
		this.hall = hall;
	}
	public ShowHall getHall() {
		return hall;
	}
	public void setHall(ShowHall hall) {
		this.hall = hall;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColum() {
		return colum;
	}
	public void setColum(int colum) {
		this.colum = colum;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
}
