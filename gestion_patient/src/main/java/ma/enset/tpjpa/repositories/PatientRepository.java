package ma.enset.tpjpa.repositories;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import ma.enset.tpjpa.entities.Patient;

import java.util.*;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	//public List<Patient> findByNameContainsAndMalade(String name, boolean malade);
	public Page<Patient> findByNameContainingIgnoreCase(String name, Pageable page);
	public void deleteById(Long id);
}
