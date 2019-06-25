package com.fdo.vo;

public class ShouRuDateVO {

	private Double fee;
	private Integer people;
	private String rate;
	private Integer unpeople;
	private Integer rens;
	private String date;
	
	public Integer getRens() {
		return rens;
	}
	public void setRens(Integer rens) {
		this.rens = rens;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Integer getPeople() {
		return people;
	}
	public void setPeople(Integer people) {
		this.people = people;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public Integer getUnpeople() {
		return unpeople;
	}
	public void setUnpeople(Integer unpeople) {
		this.unpeople = unpeople;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ShouRuDateVO(Double fee, Integer people, String rate, Integer unpeople, String date) {
		super();
		this.fee = fee;
		this.people = people;
		this.rate = rate;
		this.unpeople = unpeople;
		this.date = date;
	}
	public ShouRuDateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
