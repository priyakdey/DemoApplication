package com.example.demo.service;

import java.util.List;

import com.example.demo.model.NewStudentModel;
import com.example.demo.model.Student;

public interface IStudentService {

	List<Student> getStudentByName(String name);

	void createNewStudent(NewStudentModel student);

}
