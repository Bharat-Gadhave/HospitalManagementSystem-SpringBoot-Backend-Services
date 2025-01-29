package com.hospital.docLogin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospital.docLogin.entity.Appointment;
import com.hospital.docLogin.repository.AppointmentRepository;

@Service
public class AppointmentService {

	private AppointmentRepository appointmentRepository;

	public AppointmentService(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}
	
	public Appointment createAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	public List<Appointment> showAllAppointments(){
		return appointmentRepository.findAll();
	}
	
	public ResponseEntity<Map<String, Boolean>> deleteAppointment(int id) throws AttributeNotFoundException{
		
		Appointment appointment = appointmentRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Appointment not found with id : "+id));
		
		appointmentRepository.delete(appointment);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Deleted", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
	
}
