package com.formulario.controller;

import java.time.LocalDate;
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

import com.formulario.model.TechnicalAccount;
import com.formulario.service.ITechnicalService;


@RestController
public class TechnicalController {

	@Autowired
	private ITechnicalService techServ;
	
	@GetMapping("/TechnicalAccount/get")
	public List<TechnicalAccount> getTech(){
		List<TechnicalAccount> listTech = techServ.getListTechinian();
		return listTech;
	}
	
	@GetMapping("/TechnicalAccount/get/{id}")
	public TechnicalAccount getTech(@PathVariable Integer id) {
		return techServ.findTechnician(id);
	}
	
	@PostMapping("/TechnicalAccount/create")
	public String createTech(@RequestBody TechnicalAccount tech) {
		techServ.saveTechnician(tech);
		return "Technician Successfully created";
	}
	
	@DeleteMapping("/TechnicalAccount/delete/{id}")
	public String deleteTech(@PathVariable Integer id) {
		techServ.deleteTechnician(id);
		return "Technician successfully deleted";
	}
	
	@PutMapping("/TechnicalAccount/edit/{original_id}")
	public TechnicalAccount editTech(@PathVariable Integer original_id,@RequestParam(required=false, name="name") String newName,
																		@RequestParam(required=false, name="lastName") String newLastName,
																		@RequestParam(required=false, name="dni") String newDni,
																		@RequestParam(required=false, name="admissionDate") LocalDate newAdmissionDate,
																		@RequestParam(required=false, name="category") String newCategory,
																		@RequestParam(required=false, name="user") String newUser,
																		@RequestParam(required=false, name="password") String newPassword,
																		@RequestParam(required=false, name="rol") String newRol) {
	techServ.editTechnician(original_id, newName, newLastName,newDni, newAdmissionDate, newCategory, newUser, newPassword, newRol);
	TechnicalAccount tech = techServ.findTechnician(original_id);
	return tech;
	}
	
	@PutMapping("/TechnicalAccount/edit")
	public TechnicalAccount editTech(@RequestBody TechnicalAccount tech) {
		techServ.editTechnician(tech);
		return techServ.findTechnician(tech.getId_technician());
	}
}