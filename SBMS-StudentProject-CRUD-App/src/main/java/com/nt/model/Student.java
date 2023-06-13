package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "STUDENT_INFO")
public class Student {
		@Id
		@Column(name = "S_ROLLNO")
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Integer rollNo;
		
		@Column(name = "S_NAME")
		private String name;
		
		@Column(name = "S_AGE")
		private Integer age;
		
		@Column(name = "S_EMAIL")
		private String email;
		
		@Column(name = "S_PHONE")
		private Long phone;
		
		@Column(name = "S_BRANCH")
		private String branch;
		
		@Column(name = "S_COLLAGE")
		private String collage;
		
}
