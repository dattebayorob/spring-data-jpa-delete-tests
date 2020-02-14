package com.dtb.jpadeletetest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dtb.jpadeletetest.model.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	Optional<Person> findByCPF(String cpf);
	@Transactional
	void deleteByCPF(String cpf);
}
