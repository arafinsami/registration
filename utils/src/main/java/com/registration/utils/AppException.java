
package com.registration.utils;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AppException() {
	}

	public AppException(String s) {
		super(s);
	}

	public AppException(String s, Throwable throwable) {
		super(s, throwable);
	}

	public AppException(Throwable throwable) {
		super(throwable);
	}

	protected AppException(String s, Throwable throwable, boolean b, boolean b1) {
		super(s, throwable, b, b1);
	}
}
