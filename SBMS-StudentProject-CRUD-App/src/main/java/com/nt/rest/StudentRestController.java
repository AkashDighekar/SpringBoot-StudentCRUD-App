package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Student;
import com.nt.service.IStudentServiceMgmt;

@RestController
public class StudentRestController {
		@Autowired
		private IStudentServiceMgmt service;
		
		@PostMapping("/student")
		public ResponseEntity<String> saveStudentData(@RequestBody Student std){
			String msg = service.saveStudent(std);
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		}
		
		@GetMapping("/student")
		public ResponseEntity<List<Student>> fetchAllStudent(){
			List<Student> list = service.getAllStudent();
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		
		@GetMapping("/student/{id}")
		public ResponseEntity<Student> fetchStudentById(@PathVariable Integer id){
			Student s = service.getStudentById(id);
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		
		@PutMapping("/student/{id}")
		public ResponseEntity<Student> modifyStudentById(@PathVariable Integer id, @RequestBody Student std){
			Student s = service.updateStudent(std, id);
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		
		@DeleteMapping("/student/{id}")
		public ResponseEntity<Map<String, Boolean>> removeStudent(@PathVariable Integer id){
			Map<String, Boolean> response = service.deleteStudent(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
}
