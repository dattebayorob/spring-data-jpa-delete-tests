package com.dtb.jpadeletetest.service;

import static com.dtb.jpadeletetest.model.entities.Person.builder;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dtb.jpadeletetest.model.entities.Person;
import com.dtb.jpadeletetest.repository.PersonRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PersonServiceIT {
	@Autowired PersonService service;
	@Autowired PersonRepository repository;
	
	static final String CPF = "xxxxxxxxx00";
	static final String NAME = "Robson William da Silva Matos";
	
	@Test
	@DisplayName("Should Delete a person by CPF and then save another person with this cpf")
	void shouldDeleteAPersonByCPFAndThenSaveAnotherPersonWithThisCPF() {
		Person person =
				builder()
					.name(NAME)
					.CPF(CPF)
				.build();
		assertThatCode(() -> service.overridePersonCPF(CPF, person)).doesNotThrowAnyException();
	}

}
