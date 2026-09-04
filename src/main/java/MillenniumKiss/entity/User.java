package MillenniumKiss.entity;

//import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="users")
public class User {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(unique = true, nullable = false)
	    private String username;

	    @Column(nullable = false)
	    private String password;

	    @Column(nullable = false)
	    private String role;
	    
//	    @Column(unique=true)
//	    private String email;
	    
	    @Column(nullable = false)
	    private String name;
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

//		private String resetOtp;
	    
//	    public String getEmail() {
//			return email;
//		}
//
//		public void setEmail(String email) {
//			this.email = email;
//		}

//		public String getResetOtp() {
//			return resetOtp;
//		}
//
//		public void setResetOtp(String resetOtp) {
//			this.resetOtp = resetOtp;
//		}

//		public LocalDateTime getResetOtpExpiry() {
//			return resetOtpExpiry;
//		}
//
//		public void setResetOtpExpiry(LocalDateTime resetOtpExpiry) {
//			this.resetOtpExpiry = resetOtpExpiry;
//		}

//		private LocalDateTime resetOtpExpiry;

	    @ManyToMany
	    @JoinTable(
	        name = "user_branches",
	        joinColumns = @JoinColumn(name = "user_id"),
	        inverseJoinColumns = @JoinColumn(name = "branch_id")
	    )
	    private Set<Branch> branches = new HashSet<>();
	    
	    public User() {}

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }
	    public Set<Branch> getBranches() {
	        return branches;
	    }

	    public void setBranches(Set<Branch> branches) {
	        this.branches = branches;
	    }

}
