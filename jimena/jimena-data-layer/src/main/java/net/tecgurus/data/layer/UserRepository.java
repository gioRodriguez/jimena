package net.tecgurus.data.layer;

public interface UserRepository {

	public boolean isValidUser(String userEmail, String userPassword);

	public boolean isEmailRegistered(String userEmail);

	public int registerUser(String userName, String userEmail, String userPassword);

}