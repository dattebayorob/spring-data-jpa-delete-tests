package com.dtb.jpadeletetest.service;

import java.util.Optional;

import com.dtb.jpadeletetest.model.entities.Person;

public interface PersonService {
	Optional<Person> overridePersonCPF(String cpf, Person person);
}
