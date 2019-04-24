package com.star.paitentRegistration.service;

import java.util.List;

import com.star.paitentRegistration.entity.Patient;

public interface PatientService {
	
	public List<Patient> findAll();
	
	public void save(Patient thePatient);
	
	public void deleteById(long id);

	public Patient findByID(long patientId);
	
	
}
