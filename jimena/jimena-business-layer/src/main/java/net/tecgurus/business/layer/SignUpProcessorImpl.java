package net.tecgurus.business.layer;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import net.tecgurus.data.layer.UserRepository;
import net.tecgurus.data.layer.UserRepositoryInMemoryImpl;

import com.google.common.base.Strings;

@Component
@Scope("prototype")
public class SignUpProcessorImpl implements SignUpProcessor {
	
	private UserRepository _userRepository;
	
	public SignUpProcessorImpl() {
		_userRepository = new UserRepositoryInMemoryImpl();
	}
	
	@Override
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
