package com.formulario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formulario.model.Form;

@Repository
public interface IFormRepository extends JpaRepository<Form, Integer>{

}
