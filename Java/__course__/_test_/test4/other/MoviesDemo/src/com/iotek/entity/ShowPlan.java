package com.iotek.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class ShowPlan {
	private int id;
	private int movieId;
	private int hallId;
	private Movie movie;
	private ShowHall hall;
	private Timestamp showtime;
	private double prices;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public ShowPlan(int id, int movieId, int hallId, Timestamp showtime, double prices) {
		super();
		this.id = id;
		this.movieId = movieId;
		this.hallId = hallId;
		this.showtime = showtime;
		this.prices = prices;
	}
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
	public ShowHall getHall() {
		return hall;
	}
	public void setHall(ShowHall hall) {
		this.hall = hall;
	}
	public Timestamp getShowtime() {
		return showtime;
	}
	public void setShowtime(Timestamp showtime) {
		this.showtime = showtime;
	}
	public double getPrices() {
		return prices;
	}
	public void setPrices(double prices) {
		this.prices = prices;
	}
	public ShowPlan(int id, Movie movie, ShowHall hall, Timestamp showtime, double prices) {
		super();
		this.id = id;
		this.movie = movie;
		this.hall = hall;
		this.showtime = showtime;
		this.prices = prices;
	}
	public ShowPlan() {
		super();
	}
	
}
