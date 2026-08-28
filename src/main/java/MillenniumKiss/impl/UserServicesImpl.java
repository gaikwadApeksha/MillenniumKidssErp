package MillenniumKiss.impl;

//import java.time.LocalDateTime;
//import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import MillenniumKiss.entity.User;
import MillenniumKiss.repository.UserRepository;
import MillenniumKiss.services.UserServices;

@Service
public class UserServicesImpl implements UserServices{
	@Autowired
    private UserRepository userRepository;
	
//	 @Autowired
//	    private PasswordEncoder passwordEncoder;

    @Override
    public User login(String username, String password) {

//    	User user = userRepository.findByUsername(username)
//               .orElseThrow(() ->
//                    new RuntimeException("Invalid username or password"));
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new RuntimeException("Invalid username or password");
//        }
//        return user;
        return userRepository.findByUsernameAndPassword(username, password)
        		.orElseThrow(()-> new RuntimeException("Invalid username or password")
        				);
    }

   
    // =========================
    // REGISTER USER
    // =========================
	@Override
	public User saveuser(User user) {
		
		  // Hash password before saving
//        user.setPassword(
//            passwordEncoder.encode(user.getPassword())
//        );
		
		return userRepository.save(user);

}
	
	// =========================
    // FORGOT PASSWORD
    // =========================

//    @Override
//    public void forgotPassword(String username) {
//
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() ->
//                        new RuntimeException("User not found"));
//
//        // Check email
//        if (user.getEmail() == null || user.getEmail().isBlank()) {
//            throw new RuntimeException(
//                    "No email registered for this account"
//            );
//        }
//
//        // Generate secure random token
//        String otp = UUID.randomUUID().toString();
//
//        user.setResetOtp(otp);
//
//        // Token valid for 15 minutes
//        user.setResetOtpExpiry(
//                LocalDateTime.now().plusMinutes(15)
//        );
//
//        userRepository.save(user);
//
//        // Temporary testing
//        String resetLink =
//                "http://localhost:5173/reset-password?token=" + otp;
//
//        System.out.println("=================================");
//        System.out.println("PASSWORD RESET LINK:");
//        System.out.println(resetLink);
//        System.out.println("=================================");
//    }
//    
// // =========================
//    // RESET PASSWORD
//    // =========================
//
//    @Override
//    public void resetPassword(
//            String token,
//            String newPassword) {
//
//        User user = userRepository
//                .findByResetOtp(token)
//                .orElseThrow(() ->
//                        new RuntimeException(
//                                "Invalid or expired reset link"
//                        ));
//
//        // Check token expiry
//        if (user.getResetOtpExpiry() == null ||
//                user.getResetOtpExpiry()
//                        .isBefore(LocalDateTime.now())) {
//
//            throw new RuntimeException(
//                    "Reset link has expired"
//            );
//        }
//
//        // Hash NEW password
//        user.setPassword(
//                passwordEncoder.encode(newPassword)
//        );
//
//        // Delete token after successful reset
//        user.setResetOtp(null);
//        user.setResetOtpExpiry(null);
//
//        userRepository.save(user);
//    }
//


}