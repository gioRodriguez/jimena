package net.tecgurus.business.layer;

public interface SignUpProcessor {

	public boolean perform(String userName, String userEmail,
			String userPassword, String userConfirmPass);

}