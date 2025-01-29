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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.docLogin.entity.Medicine;
import com.hospital.docLogin.service.MedicineService;

@CrossOrigin
@RestController
@RequestMapping("/api/medicine")
public class MedicineController {

	private MedicineService medicineService;
	
	public MedicineController(MedicineService medicineService) {
		super();
		this.medicineService = medicineService ;
	}
	
	@PostMapping("/insert")
	public Medicine addMedicine(@RequestBody Medicine medicine) {
		return medicineService.addMedicine(medicine);
	}
	
	@GetMapping("/all")
	public List<Medicine> getAll(){
		return medicineService.getAll();
	}
	
	@GetMapping("/byid/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable int id) throws AttributeNotFoundException{
		return medicineService.findMedicineByid(id);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable int id,@RequestBody Medicine medicine) throws AttributeNotFoundException{
		return medicineService.updateMedicineById(id, medicine);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMedicine(@PathVariable int id) throws AttributeNotFoundException{
		return medicineService.deleteMedicineById(id);
	}
	
	
	
	
	
	
	
	
	
	
}
