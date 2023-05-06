package com.app.dtos;

public class AddHealthServiceDetailsDto {
	private Long healthServiceId;
	private String serviceDescription;
	public Long getHealthServiceId() {
		return healthServiceId;
	}
	public void setHealthServiceId(Long healthServiceId) {
		this.healthServiceId = healthServiceId;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	public AddHealthServiceDetailsDto(Long healthServiceId, String serviceDescription) {
		super();
		this.healthServiceId = healthServiceId;
		this.serviceDescription = serviceDescription;
	}
	public AddHealthServiceDetailsDto() {
		super();
	}
	
}
