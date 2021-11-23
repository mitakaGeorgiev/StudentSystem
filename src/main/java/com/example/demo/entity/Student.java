package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name = "firstName", nullable = false, length = 20)
	private String firstName;
	
	@Column(name = "lastName", nullable = false, length = 20)
	private String lastName;
	
	@Column(nullable=false,length=1)
	private int course;
	
	@ManyToMany
	@JoinTable(name= "Student_Discipline"
	,joinColumns= {
			@JoinColumn(name="student_id")
			}
	,inverseJoinColumns= {
			@JoinColumn(name="discipline_id")
			}
			
		)
	@OrderBy
	private Set<Discipline> disciplines= new HashSet<Discipline>(0);
	
	public Student() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCourse() {
		return course;
	}

	public void setCourse(int course) {
		this.course = course;
	}

	public Set<Discipline> getDisciplines() {
		return disciplines;
	}

	public void setDisciplines(Set<Discipline> disciplines) {
		this.disciplines = disciplines;
	}
	public void addDiscipline(Discipline discipline,Student student) {
		disciplines.add(discipline);
		discipline.getStudent().add(student);

   }
	
	public void RemoveDiscipline(Discipline discipline,Student student) {
		disciplines.remove(discipline);
		discipline.getStudent().add(student);

   }
	

}
