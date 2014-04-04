package net.tecgurus.web.layer.actions;

import net.tecgurus.business.layer.SignUpProcessor;

public class MockSignUpProcessor implements SignUpProcessor {

	@Override
	public boolean perform(String userName, String userEmail,
			String userPassword, String userConfirmPass) {
		if(userName != null){
			return false;
		}
		
		return true;
	}

}
