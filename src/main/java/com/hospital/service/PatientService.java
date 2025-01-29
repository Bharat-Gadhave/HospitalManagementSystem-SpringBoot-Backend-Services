package com.hospital.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospital.entity.Patient;
import com.hospital.repository.PatientRepository;

@Service
public class PatientService {

	
	private PatientRepository patientRepository;
	
	public PatientService(PatientRepository patientRepository){
		super();
		this.patientRepository = patientRepository;
	}
	
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	public List<Patient> getAll(){
		return patientRepository.findAll();
	}
	
	public ResponseEntity<Patient> getPatientById(int id) throws AttributeNotFoundException{
		
		Patient patient = patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient Not found with given id : "+id));
		
		return ResponseEntity.ok(patient);
	}
	
	public ResponseEntity<Map<String, Boolean>> deletePatientById(int id) throws AttributeNotFoundException{
		
		Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Patient not found with id : "+id));
		
		patientRepository.delete(patient);
		 
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
	public ResponseEntity<Patient> updatePatientById(int id,Patient patientDetails) throws AttributeNotFoundException{
		Patient patient = patientRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("patient not found with id : "+id));
		
		//patient.setPid(patientDetails.getPid());
		patient.setPname(patientDetails.getPname());
		patient.setPcity(patientDetails.getPcity());
		patient.setBloodGroup(patientDetails.getBloodGroup());
		patient.setFees(patientDetails.getFees());
		patient.setPnumber(patientDetails.getPnumber());
		patient.setUrgency(patientDetails.getUrgency());
		
		Patient updatedPatient = patientRepository.save(patient);
		
		return ResponseEntity.ok(updatedPatient);
	}
	
	
	
	
	
}
