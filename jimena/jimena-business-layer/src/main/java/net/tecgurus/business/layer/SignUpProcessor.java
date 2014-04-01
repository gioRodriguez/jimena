package net.tecgurus.business.layer;

import net.tecgurus.data.layer.UserResporitoryInMemoryImpl;

import com.google.common.base.Strings;

public class SignUpProcessor {
	
	private UserResporitoryInMemoryImpl _userRepository;
	
	public boolean perform(
			String userName,
			String userEmail,
			String userPassword,
			String userConfirmPass
	){
		if(Strings.isNullOrEmpty(userName) ||
				Strings.isNullOrEmpty(userEmail) ||
				Strings.isNullOrEmpty(userPassword) ||
				Strings.isNullOrEmpty(userConfirmPass)
		){			
			return false;
		}
		
		if(!userPassword.equals(userConfirmPass)){
			return false;
		}
		
		_userRepository.registerUser(
				userName, 
				userEmail, 
				userPassword
		);
		
		return true;
	}
}
