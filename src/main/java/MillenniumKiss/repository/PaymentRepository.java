package MillenniumKiss.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import MillenniumKiss.entity.DayCare;
import MillenniumKiss.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment ,Long>{
	
	List<DayCare> findByBranch(String branch);

	 @Query(value = "SELECT admission_no FROM daycare ORDER BY student_id DESC LIMIT 1", nativeQuery = true)
	    String findLastAdmissionNo();
}
