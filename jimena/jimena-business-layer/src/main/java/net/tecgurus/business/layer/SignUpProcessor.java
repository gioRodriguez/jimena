package net.tecgurus.business.layer;

import net.tecgurus.business.layer.exceptions.BusinessException;
import net.tecgurus.data.layer.exceptions.ServiceUnavailableException;

public interface SignUpProcessor {

	public long perform(
			String userName, 
			String userEmail,
			String userPassword, 
			String userConfirmPass) 
	throws 
			BusinessException, ServiceUnavailableException;

}