package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.AddHealthServiceDetailsDto;
import com.app.pojos.HealthServiceDetails;
import com.app.pojos.HealthServiceEntity;
import com.app.repositories.HealthServiceDetailsRepository;
import com.app.repositories.HealthServiceRepository;

@Service
@Transactional
public class HealthDetailsServiceImpl implements HealthDetailsService {
	
	@Autowired
	private HealthServiceDetailsRepository healthServiceDetailsRepo;

	@Autowired
	private HealthServiceRepository healthServiceRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public HealthServiceDetails addCourseDetails(AddHealthServiceDetailsDto addHealthServiceDetailsDto) {
		HealthServiceEntity healthServiceEntity = healthServiceRepo.findById(addHealthServiceDetailsDto.getHealthServiceId()).orElseThrow(() -> new RuntimeException("Course Not Found"));
		HealthServiceDetails healthServiceDetails = mapper.map(addHealthServiceDetailsDto, HealthServiceDetails.class);
		healthServiceDetails.setHealthServiceEntity(healthServiceEntity);
		healthServiceDetailsRepo.save(healthServiceDetails);
		return healthServiceDetails;
	}

	@Override
	public List<HealthServiceDetails> getAllCourseDetails(Long id) {
		HealthServiceEntity healthServiceEntity = healthServiceRepo.findById(id).orElseThrow(() -> new RuntimeException("Course Not Found"));
		List<HealthServiceDetails> listCourseDetails = healthServiceDetailsRepo.findAllByHealthServiceEntity(healthServiceEntity);
		return listCourseDetails;
	}

}
