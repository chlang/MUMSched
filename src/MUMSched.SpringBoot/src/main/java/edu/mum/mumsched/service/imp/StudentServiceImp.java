package edu.mum.mumsched.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumsched.dao.StudentDao;
import edu.mum.mumsched.domain.Student;
import edu.mum.mumsched.service.StudentService;

@Service
public class StudentServiceImp implements StudentService{

	@Override
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Autowired
	StudentDao studentDAO;
	
	public void save(Student student) {
		studentDAO.save(student);
	}
	
	@Override
	public Student getStudentById(Long studentId) {
		return studentDAO.findStudentById(studentId);
	}

	@Override
	public Student getStudentByEmail(String studentEmail) {
		return studentDAO.findStudentByEmail(studentEmail);
	}

}
