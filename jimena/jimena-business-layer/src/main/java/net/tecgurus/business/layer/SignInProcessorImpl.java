package net.tecgurus.business.layer;

import net.tecgurus.data.layer.UserRepository;
import net.tecgurus.data.layer.exceptions.ServiceUnavailableException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public boolean perform(
			String userEmail,
			String userPassword
	) throws ServiceUnavailableException{ 
		if(Strings.isNullOrEmpty(userEmail) ||
				Strings.isNullOrEmpty(userPassword)){
			return false;
		}
		
		return _userRepository.isValidUser(userEmail, userPassword);
	}
}
