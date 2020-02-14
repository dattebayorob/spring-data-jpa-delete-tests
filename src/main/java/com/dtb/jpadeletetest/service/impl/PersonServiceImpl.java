package com.dtb.jpadeletetest.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtb.jpadeletetest.model.entities.Person;
import com.dtb.jpadeletetest.repository.PersonRepository;
import com.dtb.jpadeletetest.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired private PersonRepository repository;

	@Override
	public Optional<Person> overridePersonCPF(String cpf, Person person) {
		repository.deleteByCPF(cpf);
		repository.save(person);
		return Optional.of(person);
	}
	

}
