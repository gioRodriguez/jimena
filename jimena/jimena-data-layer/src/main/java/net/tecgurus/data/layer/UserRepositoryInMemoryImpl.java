package net.tecgurus.data.layer;

import java.util.Hashtable;
import java.util.Map;

import net.tecgurus.data.layer.exceptions.ServiceUnavailableException;

import org.springframework.stereotype.Repository;

@Repository(UserRepository.MEMORY_IMPL)
public class UserRepositoryInMemoryImpl implements UserRepository {
	
	private static final Map<String, String> USERS = 
			new Hashtable<String, String>();
	
	@Override
	public boolean isValidUser(
			String userEmail, 
			String userPassword
	){
		return USERS.containsKey(userEmail);
	}
	
	@Override
	public boolean isEmailRegistered(
			String userEmail
	){
		return USERS.containsKey(userEmail);
	}
	
	@Override
	public long registerUser(
			String userName,
			String userEmail,
			String userPassword
			) throws ServiceUnavailableException{
		USERS.put(userEmail, userName);
		return 1;
	}	
}
