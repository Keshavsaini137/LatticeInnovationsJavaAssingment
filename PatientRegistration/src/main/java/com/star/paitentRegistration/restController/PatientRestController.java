package com.star.paitentRegistration.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.star.paitentRegistration.entity.Patient;
import com.star.paitentRegistration.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientRestController {
	
	private PatientService patientService;
	
	@Autowired
	public PatientRestController(PatientService thepatientService) {
		patientService = thepatientService;
	}
	
	@GetMapping("/patient")
	public List<Patient> getAllPatient(){
		return patientService.findAll();
	}
	
	@PostMapping("/patient")
	public Patient addPatient(@RequestBody @Valid Patient thePatient) {
		
		//Set id 0 if you pass id in JSON
		//So it will save instead of update
		thePatient.setId(0);
		
		thePatient.setDate();
		
		patientService.save(thePatient);
		
		return thePatient;
	}
	
	@DeleteMapping("/patient/{patientId}")
	public String deletePatient(@PathVariable long patientId) {
		System.out.println(patientId);
		Patient tempPatient = patientService.findByID(patientId);
		
		//throw exception if null
		if(tempPatient == null) {
			throw new RuntimeException("Patient Id not found - " + patientId);
		}
		
		patientService.deleteById(patientId);
		
		return "Deleted Patient Id " + patientId;
	}
	
	@PutMapping("/patient")
	public Patient updatePatient(@RequestBody Patient thePatient) {
		
		patientService.save(thePatient);
		
		return thePatient;
	}
	
	
}











