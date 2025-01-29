package com.hospital.controller;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entity.Patient;
import com.hospital.service.PatientService;

@CrossOrigin
@RestController
@RequestMapping("/api/patient")
public class PatientController {

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@PostMapping("/create")
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}

	@GetMapping("/all")
	public List<Patient> getAllPatients() {
		return patientService.getAll();
	}
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable int id) throws AttributeNotFoundException{
		return patientService.getPatientById(id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable int id) throws AttributeNotFoundException {
		return patientService.deletePatientById(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Patient patient)
			throws AttributeNotFoundException {

		return patientService.updatePatientById(id, patient);

	}

}
