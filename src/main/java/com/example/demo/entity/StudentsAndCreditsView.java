package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "list_of_student_and_credits")
public class StudentsAndCreditsView {
	@Id
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	@Column(name = "all_credits",nullable = false, length = 5)
	private String allCredits;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAllCredits() {
		return allCredits;
	}	 
}
