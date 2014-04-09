package net.tecgurus.web.layer.actions;

import net.tecgurus.business.layer.SignUpProcessor;

public class MockSignUpProcessor implements SignUpProcessor {

	@Override
	public int perform(String userName, String userEmail,
			String userPassword, String userConfirmPass) {
		if(userName != null){
			return 1;
		}
		
		return 0;
	}

}
