package com.formulario.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.formulario.model.Form;
import com.formulario.repository.IFormRepository;

@Service
public class FormService implements IFormService{

	@Autowired
	private IFormRepository formRepo;
	
	@Override
	public List<Form> getForm() {
		List<Form> listForm = formRepo.findAll();
		return listForm;
	}

	@Override
	public void saveForm(Form form) {
		LocalDate nowDate = LocalDate.now();
		LocalTime nowTime= LocalTime.now();
		form.setTime(nowTime);
		form.setDate(nowDate);
		formRepo.save(form);
	}

	@Override
	public Form findForm(Integer id) {
		Form form = formRepo.findById(id).orElse(null);
		return form;
	}

	@Override
	public void deleteForm(Integer id) {
		formRepo.deleteById(id);
	}

	@Override
	public void editForm(Integer original_id,String newtype, LocalDate newDate, LocalTime newTime, String newDescription, String newHome,
			String newFloor, String newDepartament, String newCustomerName, String newSignature) {
		Form form = this.findForm(original_id);
		form.setType(newtype);
		form.setDate(newDate);
		form.setTime(newTime);
		form.setDescription(newDescription);
		form.setHome(newHome);
		form.setFloor(newFloor);
		form.setDepartment(newDepartament);
		form.setCustomerName(newCustomerName);
		form.setSignature(newSignature);
		
		this.saveForm(form);
	}

	@Override
	public void editForm(Form form) {
		this.saveForm(form);
	}

}
