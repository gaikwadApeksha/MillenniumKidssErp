package MillenniumKiss.services;

import java.util.List;

import MillenniumKiss.entity.Student;

public interface StudentServices {
	 Student saveStudent(Student student);

	    List<Student> getAllStudents();

	    List<Student> getStudentsByBranch(String branch);
	    
	    Student getStudentById(Long id);

	    Student updateStudent(Long id, Student student);

	    void deleteStudent(Long id);
	 
}
