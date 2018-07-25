package com.iotek.entity;

import java.sql.Timestamp;

public class Ticket {
	private int id;
	private int planId;
	private ShowPlan plan;
	public ShowPlan getPlan() {
		return plan;
	}

	public void setPlan(ShowPlan plan) {
		this.plan = plan;
	}

	private String movieName;
	private int userId;
	private Timestamp buytime;
	private Seat seat;
	private Timestamp showtime;
	private double price;
	public Ticket(int id, int planId, String movieName, int userId, Timestamp buytime, Seat seat, Timestamp showtime,
			double price) {
		super();
		this.id = id;
		this.planId = planId;
		this.seat=seat;
		this.movieName = movieName;
		this.userId = userId;
		this.buytime = buytime;
		this.showtime = showtime;
		this.price = price;
	}
	
	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getShowtime() {
		return showtime;
	}
	public void setShowtime(Timestamp showtime) {
		this.showtime = showtime;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Timestamp getBuytime() {
		return buytime;
	}
	public void setBuytime(Timestamp buytime) {
		this.buytime = buytime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Ticket() {
		super();
	}
	
}
