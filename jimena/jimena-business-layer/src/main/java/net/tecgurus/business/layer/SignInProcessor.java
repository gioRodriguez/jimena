package net.tecgurus.business.layer;

public interface SignInProcessor {

	public boolean perform(String userEmail, String userPassword);

}