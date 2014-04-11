package net.tecgurus.business.layer;

import net.tecgurus.data.layer.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.common.base.Strings;

@Component
@Scope("prototype")
public class SignInProcessorImpl implements SignInProcessor {
	
	private final UserRepository _userRepository;
	
	@Autowired
	public SignInProcessorImpl(
			@Qualifier(UserRepository.IMPL) UserRepository userRepository
	) {
		_userRepository = userRepository;
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
