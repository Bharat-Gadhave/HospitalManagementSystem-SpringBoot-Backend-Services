package com.hospital.docLogin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hospital.docLogin.entity.Medicine;
import com.hospital.docLogin.repository.MedicineRepository;

@Service
public class MedicineService {

	private MedicineRepository medicineRepository;

	public MedicineService(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}
	
	public Medicine addMedicine(Medicine medicine) {
		return medicineRepository.save(medicine);
	}
	
	public List<Medicine> getAll(){
		return medicineRepository.findAll();
	}
	
	public ResponseEntity<Medicine> findMedicineByid(int id) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found For given id : "+id));
		return ResponseEntity.ok(medicine);
	}
	
	public ResponseEntity<Medicine> updateMedicineById(int id, Medicine medicineUpdate) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine not found for given id : "+id));
		
		medicine.setName(medicineUpdate.getName());
		medicine.setPrice(medicineUpdate.getPrice());
		medicine.setStock(medicineUpdate.getStock());
		medicine.setExpirydate(medicineUpdate.getExpirydate());
		
		Medicine updatedMedicine = medicineRepository.save(medicine);
		
		return ResponseEntity.ok(updatedMedicine);
		
	}
	
	public ResponseEntity<Map<String, Boolean>> deleteMedicineById(int id) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine not found for given id : "+id));

		medicineRepository.delete(medicine);
		
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Delete", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
