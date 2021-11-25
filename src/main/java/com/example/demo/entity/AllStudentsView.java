package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "list_of_all_students")
public class AllStudentsView {
	@Id
	@Column(name = "first_name", nullable = false, length = 20)
	private String firstName;
	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
	@Column(name = "course",nullable = false, length = 5)
	private String course;
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}	
	public String getCourse() {
		return course;
	}
		
}
