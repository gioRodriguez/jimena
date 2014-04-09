package net.tecgurus.business.layer;

import net.tecgurus.business.layer.exceptions.BusinessException;

public interface SignUpProcessor {

	public int perform(
			String userName, 
			String userEmail,
			String userPassword, 
			String userConfirmPass) 
	throws 
			BusinessException;

}