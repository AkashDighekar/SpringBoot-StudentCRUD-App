package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.model.Student;

public interface IStudentServiceMgmt {
		public String saveStudent(Student std);
		public List<Student> getAllStudent();
		public Student getStudentById(Integer id);
		public Student updateStudent(Student std, Integer id);
		public Map<String, Boolean> deleteStudent(Integer id);
}
