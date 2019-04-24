package com.star.paitentRegistration.dao;

import java.util.List;

import com.star.paitentRegistration.entity.Patient;

public interface PatientDAO {
	
	public List<Patient> findAll();
	
	//public Patient findById(Long id);
	
	public void save(Patient thePatient);
	
	public 	void deleteById(long id);

	public Patient findById(long patientId);
	
}
