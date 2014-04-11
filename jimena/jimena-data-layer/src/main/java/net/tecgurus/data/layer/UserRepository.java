package net.tecgurus.data.layer;

import net.tecgurus.data.layer.exceptions.ServiceUnavailableException;

public interface UserRepository {

	public static final String HIBERNATE_IMPL = "UserRepositoryHibernateImpl";
	public static final String MEMORY_IMPL = "UserRepositoryMemoryImpl";
	
	public static final String IMPL = HIBERNATE_IMPL;
	
	public boolean isValidUser(String userEmail, String userPassword);

	public boolean isEmailRegistered(String userEmail);

	public long registerUser(String userName, String userEmail, String userPassword) throws ServiceUnavailableException;

}