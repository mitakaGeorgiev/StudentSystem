package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "list_of_student_and_disciplines")
public class StudentsAndDisciplinesView  {
	
	@Id
	@Column(name = "row", nullable = false, length = 20)
	private Long id ;
	
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
    
    @Column(name="name",nullable = false, length = 45)
	private String name;


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return name;
	}

}
