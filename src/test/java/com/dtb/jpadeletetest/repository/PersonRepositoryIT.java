package com.dtb.jpadeletetest.repository;

import static com.dtb.jpadeletetest.model.entities.Person.builder;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dtb.jpadeletetest.model.entities.Person;

@DisplayName("Integration Tests Of PersonRepository")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PersonRepositoryIT {
	@Autowired PersonRepository repository;
	
	static final String CPF = "xxxxxxxxx00";
	static final String NAME = "Robson William da Silva Matos";
	

	@BeforeEach
	public void init() {
		repository.deleteAll();
		repository.save(
			builder()
				.name(NAME)
				.CPF(CPF)
			.build()
		);
	}
	
	@Test
	@DisplayName("should Find A Person By CPF")
	void shouldFindAPersonByCPF() {
		Optional<Person> person = repository.findByCPF(CPF);
		assertThat(person).isPresent();
		assertEquals(CPF, person.map(Person::getCPF).get());
	}
	
	@Test
	@DisplayName("Should Delete a Person by CPF")
	void shouldDeleteAPersonByCPF() {
		repository.deleteByCPF(CPF);
		assertThat(repository.findByCPF(CPF)).isNotPresent();
	}
	
	@Test
	@DisplayName("Should delete a person by CPF and then save another person")
	void shouldDeleteAPersonByCPFAndThenSaveAnother() {
		repository.deleteByCPF(CPF);
		assertThat(repository.findByCPF(CPF)).isEmpty();
		repository.save(builder().name(NAME).CPF(CPF).build());
	}
}
