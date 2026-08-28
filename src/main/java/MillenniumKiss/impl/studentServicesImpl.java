package MillenniumKiss.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MillenniumKiss.entity.Student;
import MillenniumKiss.repository.StudentRepository;
import MillenniumKiss.services.StudentServices;

@Service
public class studentServicesImpl implements StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    // Save Student
    @Override
    public Student  saveStudent (Student student) {
    	String lastAdmissionNo = studentRepository.findLastAdmissionNo();

        String newAdmissionNo;

        if (lastAdmissionNo == null) {
            newAdmissionNo = "MK0001";
        } else {
            int number = Integer.parseInt(lastAdmissionNo.substring(2));
            newAdmissionNo = String.format("MK%04d", number + 1);
        }

//        student.setAdmissionNo(newAdmissionNo);
//
//        return studentRepository.save(student);
        
        
        student.setAdmissionNo(newAdmissionNo);

     // New Student
     student.setPaidFees(0.0);
     student.setRemainingFees(student.getTotalFees());

     return studentRepository.save(student);
    }

    // Get All Students
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //get student by branch
    @Override
    public List<Student> getStudentsByBranch(String branch) {
        return studentRepository.findByBranch(branch);
    }
    
    // Get Student By Id
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Update Student
    @Override
    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {

//            existingStudent.setAdmissionNo(student.getAdmissionNo());
            existingStudent.setStudentName(student.getStudentName());
            existingStudent.setClassName(student.getClassName());
            existingStudent.setBranch(student.getBranch());
            existingStudent.setParentName(student.getParentName());
            existingStudent.setMobileNo(student.getMobileNo());
            existingStudent.setAlternateNum(student.getAlternateNum());
            existingStudent.setAdmissionDate(student.getAdmissionDate());
            existingStudent.setSession(student.getSession());
            existingStudent.setTotalFees(student.getTotalFees());
//            existingStudent.setRemainingFees(
//                    student.getTotalFees() - existingStudent.getPaidFees()
//            );
            
            
            return studentRepository.save(existingStudent);
        }

        return null;
    }

    // Delete Student
    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


	
}
