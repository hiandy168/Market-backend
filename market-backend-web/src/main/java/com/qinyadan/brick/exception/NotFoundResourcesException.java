package com.qinyadan.brick.exception;

public class NotFoundResourcesException extends RuntimeException {
	
	public NotFoundResourcesException() {
        super();
    }

    public NotFoundResourcesException(String message) {
        super(message);
    }

    public NotFoundResourcesException(String message, Throwable cause) {
        super(message, cause);
    }
}
