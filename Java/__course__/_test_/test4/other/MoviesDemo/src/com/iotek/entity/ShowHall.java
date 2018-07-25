package com.iotek.entity;

public class ShowHall {
	private int id;
	private Theater theater;
	private int rows;
	private int colums;
	private String title;
	private int theaterId;
	public int getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Theater getTheater() {
		return theater;
	}
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColums() {
		return colums;
	}
	public void setColums(int colums) {
		this.colums = colums;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ShowHall(int id, Theater theater, int rows, int colums, String title) {
		super();
		this.id = id;
		this.theater = theater;
		this.rows = rows;
		this.colums = colums;
		this.title = title;
	}
	public ShowHall() {
		super();
	}
}
