package com.logging.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {

	@Id
	private Long id;
	private String name;
	private String department;
	private double salary;
}
