package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="HealthServiceDetails")
public class HealthServiceDetails extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "healthServiceId")
	@JsonIgnore
	private HealthServiceEntity healthServiceEntity;
	
	@Column(nullable = false, unique = true)
	private String serviceDescription;

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public HealthServiceDetails(HealthServiceEntity healthServiceEntity, String serviceDescription) {
		super();
		this.healthServiceEntity = healthServiceEntity;
		this.serviceDescription = serviceDescription;
	}

	public HealthServiceEntity getHealthServiceEntity() {
		return healthServiceEntity;
	}

	public void setHealthServiceEntity(HealthServiceEntity healthServiceEntity) {
		this.healthServiceEntity = healthServiceEntity;
	}

	public HealthServiceDetails() {
		super();
	}
	
	
}
