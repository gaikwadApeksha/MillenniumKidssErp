package MillenniumKiss.services;

import MillenniumKiss.entity.User;

public interface UserServices {
	
	User login(String username,String password);
	User saveuser(User user);
//	void forgotPassword(String username);
//
//    void resetPassword(String token, String newPassword);

}
