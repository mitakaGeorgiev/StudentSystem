package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
@Entity
@Immutable
@Table(name = "list_of_teachers_and_disciplines")
public class AllTeachersView {
	@Id
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	@Column(name = "number_disciplines",nullable = false, length = 5)
	private String numberDisciplines;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getNumberDisciplines() {
		return numberDisciplines;
	}	
}
