package com.formulario.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Form {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id_form;
	private String type;
	private LocalDate date;
	private LocalTime time;
	private String description;
	private String home;
	private String floor;
	private String department;
	
	private String customerName;
	private String signature;
	
	
}
