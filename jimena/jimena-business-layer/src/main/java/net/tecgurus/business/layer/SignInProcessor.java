package net.tecgurus.business.layer;

import net.tecgurus.data.layer.exceptions.ServiceUnavailableException;

public interface SignInProcessor {

	public boolean perform(String userEmail, String userPassword) throws ServiceUnavailableException;

}