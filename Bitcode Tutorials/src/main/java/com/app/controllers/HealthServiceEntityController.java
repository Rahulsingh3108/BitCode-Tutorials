package com.app.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AddHealthServiceDto;
import com.app.pojos.HealthServiceEntity;
import com.app.services.HealthService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/services")
public class HealthServiceEntityController {
	
	@Autowired
	private HealthService healthService;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private JavaMailSender sender;
	
	@PostMapping("/add")
	public ResponseEntity<?> addHealthServiceEntity(@RequestBody AddHealthServiceDto coursedto) {
		return new ResponseEntity<>(healthService.addHealthService(coursedto), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getHealthServiceEntityList() {
		List<HealthServiceEntity> healthServiceEntity = healthService.getAllHealthServices();
		return new ResponseEntity<>(healthServiceEntity, HttpStatus.OK);
	}
	
	@GetMapping("/{healthServiceId}")
	public ResponseEntity<?> getHealthServiceEntityById(@PathVariable("healthServiceId") Long id) {
		HealthServiceEntity healthServiceEntity = healthService.getHealthServicesById(id);
		return new ResponseEntity<>(healthServiceEntity, HttpStatus.OK);
	}
}
