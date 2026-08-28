package MillenniumKiss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import MillenniumKiss.entity.DayCare;

@Repository
public interface DaycareRepository extends JpaRepository<DayCare,Long>{
	  @Query(value = "SELECT admission_no FROM daycare ORDER BY student_id DESC LIMIT 1", nativeQuery = true)
	  
	  String findLastAdmissionNo();
	  
	  List<DayCare> findByBranch(String branch);
	  
	
	  

}
