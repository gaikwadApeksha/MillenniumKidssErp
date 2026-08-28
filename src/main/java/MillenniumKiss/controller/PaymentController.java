package MillenniumKiss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import MillenniumKiss.entity.Payment;
import MillenniumKiss.services.PaymentServices;

@RestController
@RequestMapping("/payments")
//@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {
	
	 @Autowired
	    private PaymentServices paymentServices;


	    // Save Payment
	    @PostMapping
	    public Payment savePayment(@RequestBody Payment payment) {
	        return paymentServices.savePayment(payment);
	    }


	    // Get All Payments
	    @GetMapping
	    public List<Payment> getAllPayments() {
	        return paymentServices.getAllPayments();
	    }


	    // Get Payment By ID
	    @GetMapping("/{id}")
	    public Payment getPaymentById(@PathVariable Long id) {
	        return paymentServices.getPaymentById(id);
	    }


	    // Delete Payment
	    @DeleteMapping("/{id}")
	    public String deletePayment(@PathVariable Long id) {
	        paymentServices.deletePayment(id);
	        return "Payment deleted successfully";
	    }

}
