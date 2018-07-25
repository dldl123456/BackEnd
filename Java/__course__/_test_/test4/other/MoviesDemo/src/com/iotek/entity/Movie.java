package com.iotek.entity;

import java.sql.Date;

public class Movie {
	private int id;
	private String name;
	private String director;
	private String stars;
	private String type;
	private Date openTime;
	private String status;
	private int mins;
	private String intro;
	private double mark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getMins() {
		return mins;
	}
	public void setMins(int mins) {
		this.mins = mins;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public Movie(int id, String name, String director, String stars,String intro, String type, Date openTime, String status,
			int mins,  double mark) {
		super();
		this.id = id;
		this.name = name;
		this.director = director;
		this.stars = stars;
		this.type = type;
		this.openTime = openTime;
		this.status = status;
		this.mins = mins;
		this.intro = intro;
		this.mark = mark;
	}
	public Movie() {
		super();
	}
	@Override
	public String toString() {
		return "电影名：" + name + "\n简介：" + intro +"\n 导演：" +
				director + "\n主演：" + stars + "\n类型：" + type
				+ "\n上映时间：" + openTime +"\n时长：" + mins +  
				"\n评分"
				+ mark + "\n";
	}
	
}
