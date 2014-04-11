package net.tecgurus.data.layer;

public interface UserRepository {

	public static final String HIBERNATE_IMPL = "UserRepositoryHibernateImpl";
	public static final String MEMORY_IMPL = "UserRepositoryMemoryImpl";
	
	public boolean isValidUser(String userEmail, String userPassword);

	public boolean isEmailRegistered(String userEmail);

	public int registerUser(String userName, String userEmail, String userPassword);

}