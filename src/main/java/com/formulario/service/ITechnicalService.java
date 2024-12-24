package com.formulario.service;

import java.time.LocalDate;
import java.util.List;


import com.formulario.model.TechnicalAccount;


public interface ITechnicalService {
	
	public List<TechnicalAccount> getListTechinian();
	
	public void saveTechnician(TechnicalAccount tech);
	
	public TechnicalAccount findTechnician(Integer id);
	
	public void deleteTechnician(Integer id);
	
	public void editTechnician(Integer original_id, String newName, String newLastName,String newDni, LocalDate newAdmissionDate, String newCategory, String newUser,
								String newPassword, String newRol);
	
	public void editTechnician(TechnicalAccount tech);
}
