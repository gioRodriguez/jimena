package net.tecgurus.business.layer;

import net.tecgurus.data.layer.UserRepositoryInMemoryImpl;

import com.google.common.base.Strings;

public class SignUpProcessor {
	
	private UserRepositoryInMemoryImpl _userRepository;
	
	public SignUpProcessor() {
		_userRepository = new UserRepositoryInMemoryImpl();
	}
	
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
		
		if(_userRepository.isEmailRegistered(userEmail)){
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
