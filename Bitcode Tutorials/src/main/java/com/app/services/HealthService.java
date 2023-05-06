package com.app.services;

import java.util.List;

import com.app.dtos.AddHealthServiceDto;
import com.app.pojos.HealthServiceEntity;

public interface HealthService {
	List<HealthServiceEntity> getAllHealthServices();
	HealthServiceEntity getHealthServicesById(Long healthServiceId);
	HealthServiceEntity addHealthService(AddHealthServiceDto addHealthServiceDto);
}
