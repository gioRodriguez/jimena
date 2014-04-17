package net.tecgurus.web.layer.models;

import java.io.Serializable;

public class SignUpModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String userEmail;
	private String userPassword;
	private String userConfirmPass;
	private int userCountryId;

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

	public String getUserConfirmPass() {
		return userConfirmPass;
	}

	public void setUserConfirmPass(String userConfirmPass) {
		this.userConfirmPass = userConfirmPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserCountryId() {
		return userCountryId;
	}

	public void setUserCountryId(int userCountryId) {
		this.userCountryId = userCountryId;
	}
}
