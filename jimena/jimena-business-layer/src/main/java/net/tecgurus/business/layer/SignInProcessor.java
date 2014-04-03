package net.tecgurus.business.layer;

import com.google.common.base.Strings;

import net.tecgurus.data.layer.UserRepositoryInMemoryImpl;

public class SignInProcessor {
	private final UserRepositoryInMemoryImpl _userRepository;
	
	public SignInProcessor() {
		_userRepository = new UserRepositoryInMemoryImpl();
	}
	
	public boolean perform(
			String userEmail,
			String userPassword
	){
		if(Strings.isNullOrEmpty(userEmail) ||
				Strings.isNullOrEmpty(userPassword)){
			return false;
		}
		
		return _userRepository.isValidUser(userEmail, userPassword);
	}
}
