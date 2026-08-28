package MillenniumKiss.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "payments")
	public class Payment {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long paymentId;

	    private String receiptNo;
	    
	    private String admissionNo;

		private String studentName;

		private String branch;

	    private String className;
	     
	   private String parentName;
	   
	   private String employeeId;
	    
	    public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


		private String session;

		private String feeType;

	    private String installment;

	    private Double amount;


	    private String fine;
	    
	     private Double totalAmount;

	    private String paymentMode;

	    private String transactionId;

	    private String chequeNo;

	    private String bankName;
	    
	  
	    
	    private String remark;
	    
	    @Column(name = "payment_date")
	    private LocalDate paymentDate;

	    public String getRemark() {
			return remark;
		}


		public void setRemark(String remark) {
			this.remark = remark;
		}

		 public String getSession() {
				return session;
			}


			public void setSession(String session) {
				this.session = session;
			}


		

//		private String remarks;

	    
	    
	    public Long getPaymentId() {
			return paymentId;
		}


		public void setPaymentId(Long paymentId) {
			this.paymentId = paymentId;
		}


		public Double getTotalAmount() {
			return totalAmount;
		}


		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}


		public String getReceiptNo() {
			return receiptNo;
		}


		public void setReceiptNo(String receiptNo) {
			this.receiptNo = receiptNo;
		}


		public String getAdmissionNo() {
			return admissionNo;
		}


		public void setAdmissionNo(String admissionNo) {
			this.admissionNo = admissionNo;
		}


		public String getStudentName() {
			return studentName;
		}


		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}


		public String getBranch() {
			return branch;
		}


		public void setBranch(String branch) {
			this.branch = branch;
		}


		public String getClassName() {
			return className;
		}


		public void setClassName(String className) {
			this.className = className;
		}


		public String getFeeType() {
			return feeType;
		}


		public void setFeeType(String feeType) {
			this.feeType = feeType;
		}


		public String getInstallment() {
			return installment;
		}


		public void setInstallment(String installment) {
			this.installment = installment;
		}


		public Double getAmount() {
			return amount;
		}


		public void setAmount(Double amount) {
			this.amount = amount;
		}


		public String  getFine() {
			return fine;
		}


		public void setFine(String fine) {
			this.fine = fine;
		}


		public String getPaymentMode() {
			return paymentMode;
		}


		public void setPaymentMode(String paymentMode) {
			this.paymentMode = paymentMode;
		}


		public String getTransactionId() {
			return transactionId;
		}


		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}


		public String getChequeNo() {
			return chequeNo;
		}


		public void setChequeNo(String chequeNo) {
			this.chequeNo = chequeNo;
		}


		public String getBankName() {
			return bankName;
		}


		public void setBankName(String bankName) {
			this.bankName = bankName;
		}


		public LocalDate getPaymentDate() {
			return paymentDate;
		}


		public void setPaymentDate(LocalDate paymentDate) {
			this.paymentDate = paymentDate;
		}


		public Student getStudent() {
			return student;
		}


		public void setStudent(Student student) {
			this.student = student;
		}


	    // Relationship with Student
	    @ManyToOne
	    @JoinColumn(name = "student_id")
	    private Student student;
	
}
