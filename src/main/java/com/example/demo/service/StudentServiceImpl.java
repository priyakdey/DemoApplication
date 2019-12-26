package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.execption.StudentNotFoundException;
import com.example.demo.model.NewStudentModel;
import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	@Override
	public List<Student> getStudentByName(String name) {
		List<Student> students = this.studentRepository.findAllByName(name);
		
		if(students.isEmpty()) {
			throw new StudentNotFoundException("Student/s Not Found");
		}
		
		return students;
	}

	@Override
	public void createNewStudent(NewStudentModel student) {
		Student studentEntity = new Student();
		studentEntity.setName(student.getName());
		
		this.studentRepository.save(studentEntity);
		
	}

}
