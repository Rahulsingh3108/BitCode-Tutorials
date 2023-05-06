package com.app.services;

import java.util.List;

import com.app.dtos.AddHealthServiceDetailsDto;
import com.app.pojos.HealthServiceDetails;

public interface HealthDetailsService {
	HealthServiceDetails addCourseDetails(AddHealthServiceDetailsDto addHealthServiceDetailsDto);
	List<HealthServiceDetails> getAllCourseDetails(Long id);
}
