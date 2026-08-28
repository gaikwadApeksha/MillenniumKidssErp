package MillenniumKiss.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="daycare")
public class DayCare {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name ="student_id")
	    private Long daycareStudentId;
	 
	 @Column(name = "admission_no", unique = true, nullable = false)
	 private String admissionNo;

	 public void setAdmissionNo(String admissionNo) {
		 this.admissionNo = admissionNo;
	 }

	    public String getAdmissionNo() {
		return admissionNo;
	}
	    
	    private LocalTime fromTime;
	    
	    public LocalTime getFromTime() {
			return fromTime;
		}

		public void setFromTime(LocalTime fromTime) {
			this.fromTime = fromTime;
		}

		public LocalTime getToTime() {
			return toTime;
		}

		public void setToTime(LocalTime toTime) {
			this.toTime = toTime;
		}

		private LocalTime toTime;


        @Column(name="total_fees")
	    private Double totalFees;

		public Double getTotalFees() {
	    return totalFees;
        }

         public void setTotalFees(Double totalFees) {
	     this.totalFees = totalFees;
         }


		@Column(name = "student_name", nullable = false)
	    private String studentName;

	   
	    @Column(name = "branch")
	    private String branch;

	    @Column(name = "parent_name")
	    private String parentName;
	    
	    @Column(name="employee_id")
	    private String employeeId;

	    public String getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}

		@Column(name = "mobile_no")
	    private String mobileNo;

	    @Column(name = "alternate_no")
	    private String alternateNo;
	    
	    public Long getDaycareStudentId() {
			return daycareStudentId;
		}

		public void setDaycareStudentId(Long daycareStudentId) {
			this.daycareStudentId = daycareStudentId;
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

		public String getAlternateNo() {
			return alternateNo;
		}

		public void setAlternateNo(String alternateNo) {
			this.alternateNo = alternateNo;
		}

		public String getDaycareType() {
			return daycareType;
		}

		public void setDaycareType(String daycareType) {
			this.daycareType = daycareType;
		}

		public LocalDate getJoiningDate() {
			return joiningDate;
		}

		public void setJoiningDate(LocalDate joiningDate) {
			this.joiningDate = joiningDate;
		}

//
		@Column(name = "daycare_type")
	    private String daycareType;

	    public String getTotalHours() {
			return totalHours;
		}

		public void setTotalHours(String totalHours) {
			this.totalHours = totalHours;
		}

		@Column(name = "joining_date")
	    private LocalDate joiningDate;

	   private String  totalHours;
}
