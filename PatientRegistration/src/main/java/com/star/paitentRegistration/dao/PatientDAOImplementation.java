package com.star.paitentRegistration.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.star.paitentRegistration.entity.Patient;

@Repository
public class PatientDAOImplementation implements PatientDAO{
	
	//Define fields for entityManager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public PatientDAOImplementation(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Patient> findAll() {
		
		//Get current Session
		Session currentSesion = entityManager.unwrap(Session.class);
		
		//create a query 
		Query<Patient> theQuery = currentSesion.createQuery("From Patient Order by date DESC", Patient.class);
		
		//execute query and get the result
		List<Patient> patient = theQuery.getResultList();
		
		//return the result
		return patient;
	}


	@Override
	public void save(Patient thePatient) {
		//get the current Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Save the given(thePatient) Patient which is given in the RequestBody
		//If id=0 save/insert else Update..
		System.out.println(thePatient.getDate());
		currentSession.saveOrUpdate(thePatient);
		
	}


	@Override
	public void deleteById(long id) {
		//get the current Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete a Patient from the database by given Id
		currentSession.createQuery("delete from Patient where id =" + id).executeUpdate();
	}


	@Override
	public Patient findById(long patientId) {
		//Get a current Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//Retrieve the Patient by the given id
		Patient tempPatient = currentSession.get(Patient.class, patientId);
		
		return tempPatient;
	}

}
