package com.hospital.docLogin.controller;

import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.docLogin.entity.Appointment;
import com.hospital.docLogin.service.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin
public class AppointmentController {

	private AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}
	
	@PostMapping("/create")
	public Appointment addAppointment(@RequestBody Appointment appointment) {
		return appointmentService.createAppointment(appointment);
	}
	
	@GetMapping("/all")
	public List<Appointment> allAppointments(){
		return appointmentService.showAllAppointments();
	}
	
	@DeleteMapping("/deleteby/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAppointmentById(@PathVariable int id) throws AttributeNotFoundException{
		return appointmentService.deleteAppointment(id);
	}
}
