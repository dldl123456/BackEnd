package com.iotek.entity;

public class User {
	private int id;
	private String name;
	private String  psw;
	private int age;
	private String sex;
	private String adress;
	private String tel;
	private String rank;
	private double balance;
	private double cost;
	public User() {
		super();
	}
	public User(int id, String name, String psw, int age, String sex, String adress, String tel, String rank,
			double balance, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.psw = psw;
		this.age = age;
		this.sex = sex;
		this.adress = adress;
		this.tel = tel;
		this.rank = rank;
		this.balance = balance;
		this.cost = cost;
	}
	public String getRank() {
		setRank();
		return rank;
	}
	public void setRank(String rank){
		this.rank=rank;
	}
	public void setRank() {
		if((balance+cost)<100){
			this.rank="1";
			return;
		}
		if((balance+cost)<500){
			this.rank="2";
			return;
		}if((balance+cost)<1000){
			this.rank="3";
			return;
		}if((balance+cost)<2000){
			this.rank="4";
			return;
		}
		if((balance+cost)<5000){
			this.rank="5";
			return;
		}
		this.rank="6";
	}
	public String  getRank(double money) {
		if((balance+cost)<100){
			return "1";
		}
		if((balance+cost)<500){
			return "2";
			
		}if((balance+cost)<1000){
			return "3";
			
		}if((balance+cost)<2000){
			return "4";
		}
		if((balance+cost)<5000){
			return "5";
		}
		return "6";
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
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
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public double getDiscount(){
		getRank();
		switch(rank){
		case "1":
			return 1;
		case "2":
			return 0.9;
		case "3":
			return 0.8;
		case "4":
			return 0.7;
		case "5":
			return 0.6;
		case "6":
			return 0.5 ;
			default:
				break;
		}
		return 1;
	}
}
