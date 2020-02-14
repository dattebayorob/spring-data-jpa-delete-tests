package com.dtb.jpadeletetest.model.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "jpa", name = "person")
public class Person implements Serializable{
	private static final long serialVersionUID = -1162537662277475048L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String CPF;
	@Column(nullable = false)
	private String name;
}
