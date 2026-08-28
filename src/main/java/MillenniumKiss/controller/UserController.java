package MillenniumKiss.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import MillenniumKiss.entity.Branch;
import MillenniumKiss.entity.User;
import MillenniumKiss.repository.BranchRepository;
import MillenniumKiss.repository.UserRepository;
import MillenniumKiss.services.UserServices;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin(origins="http://localhost:5173")
public class UserController {

	 @Autowired
	    private UserServices userServices;
	
	 @Autowired
	    private UserRepository userRepository;

	 @Autowired
	    private BranchRepository branchRepository;

	  @PostMapping("/login")
	    public User login(@RequestBody User user) {

	        return userServices.login(
	                user.getUsername(),
	                user.getPassword()
	        );
	    }
	    @PostMapping("/assign-branches")
	    public User assignBranches(@RequestBody BranchAssignmentRequest request) {

	        User user = userRepository.findById(request.getUserId())
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        List<Branch> branches = branchRepository.findAllById(request.getBranchIds());

	        user.setBranches(new HashSet<>(branches));

	        return userRepository.save(user);
	    }
	    public static class BranchAssignmentRequest {

	        private Long userId;
	        private Set<Long> branchIds;

	        public Long getUserId() {
	            return userId;
	        }

	        public void setUserId(Long userId) {
	            this.userId = userId;
	        }

	        public Set<Long> getBranchIds() {
	            return branchIds;
	        }

	        public void setBranchIds(Set<Long> branchIds) {
	            this.branchIds = branchIds;
	        }
	    }
//	    
//	    @PostMapping("/register")
//	    public User register(@RequestBody User user) {
//	        return userServices.saveuser(user);
//	    }
//	    @PostMapping("/forgot-password")
//	    public String forgotPassword(@RequestBody ForgotPasswordRequest request) {
//
//	        userServices.forgotPassword(request.getUsername());
//
//	        return "If the account exists, a password reset link has been generated.";
//	    }
	    
//	    @PostMapping("/reset-password")
//	    public String resetPassword(
//	            @RequestBody ResetPasswordRequest request) {
//
//	        userServices.resetPassword(
//	                request.getToken(),
//	                request.getNewPassword()
//	        );
//
//	        return "Password reset successfully";
//	    }
}
