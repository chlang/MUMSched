package edu.mum.mumsched.service;

import java.util.List;

import edu.mum.mumsched.domain.Student;

public interface StudentService {
	void save(Student student);

	Student getStudentById(Long studentId);

	Student getStudentByEmail(String studentEmail);
	
	List<Student> getStudents();
}
