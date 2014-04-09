package net.tecgurus.business.layer.exceptions;

public class EmailAlreadyRegisteredException extends BusinessException {
	private static final long serialVersionUID = 1L;

	public EmailAlreadyRegisteredException() {
		super();
	}

	public EmailAlreadyRegisteredException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailAlreadyRegisteredException(String message) {
		super(message);
	}

	public EmailAlreadyRegisteredException(Throwable cause) {
		super(cause);
	}

}
