package net.tecgurus.data.layer;

import java.util.Hashtable;
import java.util.Map;

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
	public int registerUser(
			String userName,
			String userEmail,
			String userPassword
			){
		USERS.put(userEmail, userName);
		return 1;
	}	
}
