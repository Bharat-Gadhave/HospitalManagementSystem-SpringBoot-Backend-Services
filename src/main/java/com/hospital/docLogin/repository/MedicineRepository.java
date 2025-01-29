package com.hospital.docLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.docLogin.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer>{

}
