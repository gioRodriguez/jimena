package net.tecgurus.business.layer;


import net.tecgurus.business.layer.exceptions.BusinessException;
import net.tecgurus.business.layer.exceptions.ConfirmPassNotMatchException;
import net.tecgurus.business.layer.exceptions.EmailAlreadyRegisteredException;
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
public class SignUpProcessorImpl implements SignUpProcessor {
	
	private UserRepository _userRepository;
	
	@Autowired
	public SignUpProcessorImpl(
			@Qualifier(UserRepository.IMPL) UserRepository userRepository
	) {
		_userRepository = userRepository;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public long perform(
			String userName,
			String userEmail,
			String userPassword,
			String userConfirmPass
	) 
	throws 
		BusinessException, ServiceUnavailableException
	{
		if(Strings.isNullOrEmpty(userName) ||
				Strings.isNullOrEmpty(userEmail) ||
				Strings.isNullOrEmpty(userPassword) ||
				Strings.isNullOrEmpty(userConfirmPass)
		){			
			throw new BusinessException("data invalid");
		}
		
		if(!userPassword.equals(userConfirmPass)){
			throw new ConfirmPassNotMatchException();
		}
		
		if(_userRepository.isEmailRegistered(userEmail)){
			throw new EmailAlreadyRegisteredException();
		}
		
		return _userRepository.registerUser(
				userName, 
				userEmail, 
				userPassword
		);
	}
}
