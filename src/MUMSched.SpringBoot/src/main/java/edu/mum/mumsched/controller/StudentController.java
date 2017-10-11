package edu.mum.mumsched.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.mumsched.domain.Student;
import edu.mum.mumsched.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String studentList(@ModelAttribute("studentList") ArrayList<Student> students, Model model) {
		students = new ArrayList<>(studentService.getStudents());
		
		model.addAttribute("studentList", students);
		return "studentList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	//@RequestMapping("/")
	public String studentRegForm(@ModelAttribute("newStudent") Student student, Model model) {
		model.addAttribute("newstudent", student);
		return "studentregform";
	}

	@RequestMapping(value = "/addnewstudent", method = RequestMethod.POST)
	public String registerStudent(@ModelAttribute("newStudent") Student studenta, Model model) {
		// Save in Persistence
		studentService.save(studenta);

		// Get Student from Persistence
		model.addAttribute("student", studentService.getStudentByEmail(studenta.getEmail()));
		return "addsuccess";
	}
}
