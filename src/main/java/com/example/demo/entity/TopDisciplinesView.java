package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;
@Entity
@Immutable
@Table(name = "list_top_3_disciplines")
public class TopDisciplinesView {
	
	@Id
	@Column(name = "name", nullable = false, length = 20)
	private String disciplineName;
	@Column(name = "enrolled_students", nullable = false, length = 20)
	private String numberStudents;
	public String getDisciplineName() {
		return disciplineName;
	}
	public String getNumberStudents() {
		return numberStudents;
	}	
}
