package com.chaos.vo;

import java.io.Serializable;

public class RacketVO extends TaggableItem implements Serializable {

	private static final long	serialVersionUID	= -813991140519940413L;

	private int					id;

	private double				balancePoint;

	private String				brand;

	private String				code;

	private String				color;

	private String				frame;

	private String				grip;

	private String				name;

	private String				remarks;

	private String				shaft;

	private double				weight;

	private String				country;

	public RacketVO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalancePoint() {
		return this.balancePoint;
	}

	public void setBalancePoint(double balancePoint) {
		this.balancePoint = balancePoint;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFrame() {
		return this.frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getGrip() {
		return this.grip;
	}

	public void setGrip(String grip) {
		this.grip = grip;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getShaft() {
		return this.shaft;
	}

	public void setShaft(String shaft) {
		this.shaft = shaft;
	}

	public double getWeight() {
		return this.weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}