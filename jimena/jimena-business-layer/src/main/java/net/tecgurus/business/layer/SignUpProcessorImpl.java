package net.tecgurus.business.layer;

import net.tecgurus.data.layer.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

@Component
@Scope("prototype")
public class SignUpProcessorImpl implements SignUpProcessor {
	
	private UserRepository _userRepository;
	
	@Autowired
	public SignUpProcessorImpl(
			UserRepository userRepository
	) {
		_userRepository = userRepository;
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
