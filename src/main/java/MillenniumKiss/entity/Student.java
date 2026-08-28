package MillenniumKiss.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
	
	@OneToMany
	@JsonIgnore
	private List<Payment> payments;
    
	@Column( name="admission_No" , unique=true , nullable = false)
    private String admissionNo;
	
    @NotBlank(message = "Student name is required")
    private String studentName;
    
//    private LocalDate dateOfBirth;
    
    @Column(name="class_name")
    private String className;
    
    private String branch;
    
    private String parentName;
   
    @Pattern(regexp = "[0-9]{10}",message = "Mobile number must be 10 digits")
    
    private String mobileNo;
    
    private String alternateNum;
    
    private LocalDate admissionDate;
    
    private String session;
    
    @Column(nullable = false)
    private Double totalFees;
    
    
    @Column(name="paid_fees")
    private Double paidFees ;

    @Column(name="remaining_fees")
    private Double remainingFees;

	public Double getPaidFees() {
		return paidFees;
	}

	public void setPaidFees(Double paidFees) {
		this.paidFees = paidFees;
	}

	public Double getRemainingFees() {
		return remainingFees;
	}

	public void setRemainingFees(Double remainingFees) {
		this.remainingFees = remainingFees;
	}

	public Double getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(Double totalFees) {
		this.totalFees = totalFees;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAlternateNum() {
		return alternateNum;
	}

	public void setAlternateNum(String alternateNum) {
		this.alternateNum = alternateNum;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}
   
}
