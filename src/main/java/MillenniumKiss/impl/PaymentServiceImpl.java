package MillenniumKiss.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MillenniumKiss.entity.Payment;
import MillenniumKiss.entity.Student;
import MillenniumKiss.repository.PaymentRepository;
import MillenniumKiss.repository.StudentRepository;
import MillenniumKiss.services.PaymentServices;

@Service
public class PaymentServiceImpl implements PaymentServices {
	
	
	  @Autowired
	    private PaymentRepository paymentRepository;
	  
	  @Autowired
	  private StudentRepository studentRepository;


	    @Override
	    public Payment savePayment(Payment payment) {
	    	

	        System.out.println("Payment Admission No = " + payment.getAdmissionNo());
	    	
	    	Optional<Student> optionalStudent =
	                studentRepository.findByAdmissionNo(payment.getAdmissionNo());
	    	
	    	System.out.println("Student Found = " + optionalStudent.isPresent());

	        if (optionalStudent.isPresent()) {

	            Student student = optionalStudent.get();
	            
	            System.out.println("Before Update");
	            System.out.println("Old Fees = " + student.getPaidFees());
	            System.out.println("Old Remaining = " + student.getRemainingFees());

	            Double paidAmount = payment.getAmount();
//	            Double paidAmount = payment.getAmount() == null ? 0.0 : payment.getAmount();

	            if (student.getPaidFees() == null) {
	                student.setPaidFees(0.0);
	            }

	            student.setPaidFees(student.getPaidFees() + paidAmount);

	            student.setRemainingFees(
	                    student.getTotalFees() - student.getPaidFees()
	            );

	            studentRepository.save(student);
	            System.out.println("Student Saved Successfully");
	        }  
	        else {
	        	 System.out.println("Student NOT Found");
	        	
	        }

	        if (payment.getTransactionId() == null) {
	            payment.setTransactionId("");
	        }
	        
	        if(payment.getFine() == null) {
	        	payment.setFine("");
	        }

	       
	        if (payment.getChequeNo() == null) {
	            payment.setChequeNo("");
	        }

	        if (payment.getBankName() == null) {
	            payment.setBankName("");
	        }
	        
	        return paymentRepository.save(payment);
	    }


	    @Override
	    public List<Payment> getAllPayments() {
	        return paymentRepository.findAll();
	    }


	    @Override
	    public Payment getPaymentById(Long id) {
	        return paymentRepository.findById(id)
	                .orElse(null);
	    }


	    @Override
	    public void deletePayment(Long id) {
	        paymentRepository.deleteById(id);
	    }

}
