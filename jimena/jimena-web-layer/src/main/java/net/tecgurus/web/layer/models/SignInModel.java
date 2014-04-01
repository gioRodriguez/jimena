package net.tecgurus.web.layer.models;

import java.io.Serializable;

public class SignInModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String userEmail;
	private String userPassword;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
