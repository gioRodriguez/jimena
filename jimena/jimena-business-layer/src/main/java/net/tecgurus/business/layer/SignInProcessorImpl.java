package net.tecgurus.business.layer;

import com.google.common.base.Strings;

import net.tecgurus.data.layer.UserRepository;
import net.tecgurus.data.layer.UserRepositoryInMemoryImpl;

public class SignInProcessorImpl implements SignInProcessor {
	private final UserRepository _userRepository;
	
	public SignInProcessorImpl() {
		_userRepository = new UserRepositoryInMemoryImpl();
	}
	
	@Override
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
