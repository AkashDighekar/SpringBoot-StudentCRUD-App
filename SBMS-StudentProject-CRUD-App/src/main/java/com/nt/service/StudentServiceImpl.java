package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nt.model.Student;
import com.nt.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentServiceMgmt{
	
		private StudentRepository repo;
	
		public StudentServiceImpl(StudentRepository repo) {
			this.repo = repo;
		}
		
		@Override
		public String saveStudent(Student std) {
			repo.save(std);
			return "Student Added Successfully";
		}
	
		@Override
		public List<Student> getAllStudent() {
			return repo.findAll();
		}
		
		@Override
		public Student getStudentById(Integer id) {
			Student s = repo.findById(id).orElseThrow(()-> new IllegalAccessError("Student not exist in this id"+ id));
			return s;
		}
		
		@Override
		public Student updateStudent(Student std, Integer id) {
			Student s = repo.findById(id).orElseThrow(()-> new IllegalAccessError("Student not exist in this id"+ id));
			s.setName(std.getName());
			s.setAge(std.getAge());
			s.setPhone(std.getPhone());
			s.setBranch(std.getBranch());
			s.setCollage(std.getCollage());
			Student updateStd = repo.save(s);
			return updateStd;
		}
	
		@Override
		public Map<String, Boolean> deleteStudent(Integer id) {
			Student s = repo.findById(id).orElseThrow(()-> new IllegalAccessError("Student not exist in this id"+ id));
			repo.delete(s);
			Map<String, Boolean> result = new HashMap<>();
			result.put("Student Deleted", Boolean.TRUE);
			return result;
		}

		

}
