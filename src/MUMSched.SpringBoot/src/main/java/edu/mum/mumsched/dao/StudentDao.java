package edu.mum.mumsched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.mumsched.domain.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Long> {

	@Query("select s from Student s where s.id = :id")
	public Student findStudentById(@Param("id") Long studentId);

	@Query("select s from Student s where s.email= :email")
	public Student findStudentByEmail(@Param("email") String email);
	
	@Query("select s from Student s")
	public List<Student> getStudents();
}
