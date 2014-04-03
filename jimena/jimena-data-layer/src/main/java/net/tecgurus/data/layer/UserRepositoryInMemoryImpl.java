package net.tecgurus.data.layer;

import java.util.Hashtable;
import java.util.Map;

public class UserRepositoryInMemoryImpl {
	
	private static final Map<String, String> USERS = 
			new Hashtable<String, String>();
	
	public boolean isValidUser(
			String userEmail, 
			String userPassword
	){
		return USERS.containsKey(userEmail);
	}
	
	public boolean isEmailRegistered(
			String userEmail
	){
		return USERS.containsKey(userEmail);
	}
	
	public int registerUser(
			String userName,
			String userEmail,
			String userPassword
			){
		USERS.put(userEmail, userName);
		return 1;
	}	
}
