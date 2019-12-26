package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.NewStudentModel;
import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;

@RestController
@RequestMapping(path = "/students", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class StudentController {

	private IStudentService studentService;
	
	@Autowired
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<Student>> getStudentByName(@PathVariable String name) {
		List<Student> students = this.studentService.getStudentByName(name);
		return new ResponseEntity<List<Student>>(students, HttpStatus.FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Object> createNewStudent(@RequestBody NewStudentModel student) {
		this.studentService.createNewStudent(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
