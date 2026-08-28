package MillenniumKiss.repository;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import MillenniumKiss.entity.User;

public interface UserRepository extends JpaRepository<User , Long> {
	
//	 User  findByUsernameAndPassword(String username , String password);
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByUsernameAndPassword(
            String username,
            String password
    );

//
//    Optional<User> findByEmail(String email);
//    
//    Optional<User> findByResetOtp(String resetOtp);
}
