package com.formulario.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formulario.model.TechnicalAccount;
import com.formulario.repository.ITechnicalRepository;

@Service
public class TechnicalService implements ITechnicalService{

	@Autowired
	ITechnicalRepository techRepo;
	
	@Override
	public List<TechnicalAccount> getListTechinian() {
		List<TechnicalAccount> listTechnical = techRepo.findAll();
		return listTechnical;
	}

	@Override
	public void saveTechnician(TechnicalAccount tech) {
		techRepo.save(tech);
	}

	@Override
	public TechnicalAccount findTechnician(Integer id) {
		TechnicalAccount tech = techRepo.findById(id).orElse(null);
		return tech;
	}

	@Override
	public void deleteTechnician(Integer id) {
		techRepo.deleteById(id);
	}

	@Override
	public void editTechnician(Integer original_id, String newName, String newLastName,String newDni, LocalDate newAdmissionDate,
			String newCategory, String newUser, String newPassword, String newRol) {
		
		TechnicalAccount tech = this.findTechnician(original_id);
		tech.setName(newName);
		tech.setLastName(newLastName);
		tech.setDni(newDni);
		tech.setAdmissionDate(newAdmissionDate);
		tech.setCategory(newCategory);
		tech.setUser(newUser);
		tech.setPassword(newPassword);
		tech.setRol(newRol);
		
		this.saveTechnician(tech);
		
		
		
	}

	@Override
	public void editTechnician(TechnicalAccount tech) {
		this.saveTechnician(tech);
	}

}
