package com.formulario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formulario.model.TechnicalAccount;

@Repository
public interface ITechnicalRepository extends JpaRepository<TechnicalAccount, Integer>{

}
