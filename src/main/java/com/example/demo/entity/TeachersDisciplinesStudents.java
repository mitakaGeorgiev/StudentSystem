package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
@Entity
@Immutable
@Table(name = "list_of_teachers_disciplines_and_enrolled_students")
public class TeachersDisciplinesStudents {
	@Id
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 20)
	private String lastName;
    
    @Column(name="discipline",nullable = false, length = 45)
	private String discipline;
    
    @Column(name="enrolled_students",nullable = false, length = 45)
	private String enrolled_students;

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDiscipline() {
		return discipline;
	}
	public String getEnrolled_students() {
		return enrolled_students;
	}
	

}
