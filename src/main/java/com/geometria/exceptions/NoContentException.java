package com.geometria.exceptions;

public class NoContentException extends Exception{

	private static final long serialVersionUID = 3798264750629157527L;

	public NoContentException() {
		super();
	}

	public NoContentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NoContentException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoContentException(String message) {
		super(message);
	}

	public NoContentException(Throwable cause) {
		super(cause);
	}
}
