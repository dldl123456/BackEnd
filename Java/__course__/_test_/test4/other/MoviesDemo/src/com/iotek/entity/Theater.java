package com.iotek.entity;

public class Theater {
	private int id;
	private String city;
	private String adress;
	private String name;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Theater() {
		super();
	}
	public Theater(int id, String city, String adress, String name) {
		super();
		this.id = id;
		this.city = city;
		this.adress = adress;
		this.name = name;
	}
	
	
}
