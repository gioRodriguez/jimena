package net.tecgurus.business.layer.exceptions;

public class ConfirmPassNotMatchException extends BusinessException {
	private static final long serialVersionUID = 1L;

	public ConfirmPassNotMatchException() {
		super();
	}

	public ConfirmPassNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConfirmPassNotMatchException(String message) {
		super(message);
	}

	public ConfirmPassNotMatchException(Throwable cause) {
		super(cause);
	}
	
	

}
