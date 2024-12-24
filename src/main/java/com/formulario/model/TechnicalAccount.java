package com.formulario.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class TechnicalAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id_technician;
	private String name;
	private String lastName;
	private String dni;
	private LocalDate admissionDate;
	private String category;
	private String user;
	private String password;
	private String rol;
	
	@OneToMany
	private List<Form> listForm;
}
