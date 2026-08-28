package MillenniumKiss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MillenniumKiss.entity.Student;
import MillenniumKiss.services.StudentServices;


@RestController
@RequestMapping("/api/students")
//@CrossOrigin(origins = "http://localhost:5173")
public class studentController {
	
	
	public studentController() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<Student Controller Loaded >>>>>>>>>>>>>>>>>");
	}
	
	 @Autowired
	    private StudentServices studentService;

	    // Save Student
	    @PostMapping("/save")
	    public Student saveStudent(@RequestBody Student student) {
	        return studentService.saveStudent(student);
	    }

	    // Get All Students
	    @GetMapping("/all")
	    public List<Student> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    // Get Student By Id
	    @GetMapping("/{id}")
	    public Student getStudentById(@PathVariable Long id) {
	        return studentService.getStudentById(id);
	    }

	    // Update Student
	    @PutMapping("/update/{id}")
	    public Student updateStudent(@PathVariable Long id,
	                                       @RequestBody Student student) {
	        return studentService.updateStudent(id, student);
	    }
	    
	    @GetMapping("/branch/{branch}")
	    public List<Student> getStudentsByBranch(@PathVariable String branch) {
	        return studentService.getStudentsByBranch(branch);
	    }

	    // Delete Student
	    @DeleteMapping("/delete/{id}")
	    public String  deleteStudent(@PathVariable Long id) {
	        studentService.deleteStudent(id);
	        return "stuent deleted succesfully.";
	    }
	    
	    @GetMapping("/test")
	    public String test() {
	        return "Student Controller Working";
	    }

}
