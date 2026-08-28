package MillenniumKiss.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import MillenniumKiss.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
	
	  @Query(value = "SELECT admission_no FROM students ORDER BY student_id DESC LIMIT 1", nativeQuery = true)
	    String findLastAdmissionNo();
	  
	  List<Student> findByBranch(String branch);
	  
	  Optional<Student> findByAdmissionNo(String admissionNo);
}
