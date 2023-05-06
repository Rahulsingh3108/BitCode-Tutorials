package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.AddHealthServiceDto;
import com.app.pojos.HealthServiceEntity;
import com.app.repositories.HealthServiceRepository;

@Service
@Transactional
public class HealthServiceImpl implements HealthService {
	
	@Autowired
	private HealthServiceRepository healthServiceRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<HealthServiceEntity> getAllHealthServices() {
		List<HealthServiceEntity> listHealthServices= healthServiceRepo.findAll();
		return listHealthServices;
	}

	@Override
	public HealthServiceEntity getHealthServicesById(Long courseId) {
		if (healthServiceRepo.existsById(courseId)) {
			HealthServiceEntity healthServiceEntity = healthServiceRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course Not Found"));
			return healthServiceEntity;
		}
		return null;
	}

	@Override
	public HealthServiceEntity addHealthService(AddHealthServiceDto addCourseDto) {
		HealthServiceEntity healthServiceEntity = mapper.map(addCourseDto, HealthServiceEntity.class);
		healthServiceRepo.save(healthServiceEntity);
		return healthServiceEntity;
	}
}