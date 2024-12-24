package com.formulario.controller;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formulario.model.Form;
import com.formulario.service.IFormService;

@RestController
public class FormController {

	@Autowired
	private IFormService formServ;
	
	@GetMapping("/form/get")
	public List<Form> getForm(){
		List<Form> listForm = formServ.getForm();
		return listForm;
	}
	
	@GetMapping("/form/get/{id}")
	public Form getFindForm(@PathVariable Integer id) {
		return formServ.findForm(id);
	}
	
	@PostMapping("/form/create")
	public String createForm(@RequestBody Form form) {
		formServ.saveForm(form);
		return "Form successfully created";
	}
	
	@DeleteMapping("/form/delete/{id}")
	public String deleteForm(@PathVariable Integer id) {
		formServ.deleteForm(id);
		return "Form sucessfully deleted";
	}
	
	@PutMapping("/form/edit/{original_id}")
	public Form editForm(@PathVariable Integer original_id, @RequestParam(required=false, name="type") String newType,
															@RequestParam(required=false,name="date") LocalDate newDate,
															@RequestParam(required=false,name="time") LocalTime newTime,
															@RequestParam(required=false,name="description") String newDescription,
															@RequestParam(required=false,name="home") String newHome,
															@RequestParam(required=false,name="floor") String newFloor,
															@RequestParam(required=false,name="department") String newDepartment,
															@RequestParam(required=false,name="customerName") String newCustomerName,
															@RequestParam(required=false,name="signature") String newSignature){
		formServ.editForm(original_id, newType, newDate, newTime, newDescription, newHome, newFloor, newDepartment, newCustomerName, newSignature);
		Form form = formServ.findForm(original_id);
		return form;
	}
	
	@PutMapping("/form/edit")
	public Form editForm(@RequestBody Form form) {
		formServ.editForm(form);
		return formServ.findForm(form.getId_form());
	}
	
}
