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

import com.app.dtos.AddHealthServiceDetailsDto;
import com.app.pojos.HealthServiceDetails;
import com.app.services.HealthDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/courseDetails")
public class HealthServiceDetailsController {

	@Autowired
	private HealthDetailsService healthDetailsService;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private JavaMailSender sender;
	
	@PostMapping("/add")
	public ResponseEntity<?> addCourseDetails(@RequestBody AddHealthServiceDetailsDto addHealthServiceDetailsDto) {
		return new ResponseEntity<>(healthDetailsService.addCourseDetails(addHealthServiceDetailsDto), HttpStatus.OK);
	}

	@GetMapping("/{healthServiceId}")
	public ResponseEntity<?> getCoursesDetailsByCourseId(@PathVariable("healthServiceId") Long id) {
		List<HealthServiceDetails> listHealthServiceDetails = healthDetailsService.getAllCourseDetails(id);
		return new ResponseEntity<>(listHealthServiceDetails, HttpStatus.OK);
	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getCourseById(@PathVariable("id") Long id) {
//		Course savedCourse = courseDetailsService.getCourseById(id);
//		return new ResponseEntity<>(savedCourse, HttpStatus.OK);
//	}
}
