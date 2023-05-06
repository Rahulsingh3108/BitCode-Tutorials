package com.app.dtos;

public class AddHealthServiceDto {
	private String serviceName;
	private String mentor;
	private double price;
	private int duration;
	private String description;
	private String imagePath;
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getMentor() {
		return mentor;
	}
	public void setMentor(String mentor) {
		this.mentor = mentor;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public AddHealthServiceDto(String serviceName, String mentor, double price, int duration, String description,
			String imagePath) {
		super();
		this.serviceName = serviceName;
		this.mentor = mentor;
		this.price = price;
		this.duration = duration;
		this.description = description;
		this.imagePath = imagePath;
	}
	public AddHealthServiceDto() {
		super();
	}
	
	
}
