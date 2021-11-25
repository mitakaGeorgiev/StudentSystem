package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "top3_teachers_with_enrolled_studends")
public class TopTeachersWithEnrolledStudentsView {
	@Id
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	@Column(name = "all_enrolled_students",nullable = false, length = 5)
	private String allStudents;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}	
	public String getAllStudents() {
		return allStudents;
	}	
}
