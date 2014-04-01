package net.tecgurus.business.layer;

public class SignUpProcessor {
	
	public boolean perform(
			String userName,
			String userEmail,
			String userPassword,
			String userConfirmPass
	){
		if("gio".equals(userName)){
			return true;
		}
		
		return false;
	}
}
