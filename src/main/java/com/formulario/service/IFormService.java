package com.formulario.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;



import com.formulario.model.Form;


public interface IFormService {

	public List<Form> getForm();
	
	public void saveForm(Form form);
	
	public Form findForm(Integer id);
	
	public void deleteForm(Integer id);
	
	public void editForm(Integer original_id,String newtype, LocalDate newDate, LocalTime newTime, String newDescription, String newHome,
							String newFloor, String newDepartament, String newCustomerName, String newSignature);
	
	public void editForm(Form form);
	
}
