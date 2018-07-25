package com.iotek.entity;

public class Review {
	private int id;
	private Movie movie;
	private int tickId;
	private double mark;
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Review(int id, Movie movie, int tickId, double mark, String comments) {
		super();
		this.id = id;
		this.movie = movie;
		this.tickId = tickId;
		this.mark = mark;
		this.comments = comments;
	}
	public int getTickId() {
		return tickId;
	}
	public void setTickId(int tickId) {
		this.tickId = tickId;
	}
	public Review() {
		super();
	}
	
}
