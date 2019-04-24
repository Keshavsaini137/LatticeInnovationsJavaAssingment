package com.star.paitentRegistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.star.paitentRegistration.dao.PatientDAO;
import com.star.paitentRegistration.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientDAO patientDAO;
	
	@Autowired
	public PatientServiceImpl(PatientDAO thePatientDAO) {
		patientDAO = thePatientDAO;
	}
	
	@Override
	@Transactional
	public List<Patient> findAll() {
		return patientDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Patient thePatient) {
		patientDAO.save(thePatient);
	}

	@Override
	@Transactional
	public void deleteById(long id) {
		patientDAO.deleteById(id);
	}

	@Override
	@Transactional
	public Patient findByID(long patientId) {
		Patient tempPatient = patientDAO.findById(patientId);
		return tempPatient;
	}

}
