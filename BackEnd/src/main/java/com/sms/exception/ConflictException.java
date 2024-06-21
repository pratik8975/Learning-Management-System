
package com.sms.exception;

public class ConflictException extends RuntimeException {
	
	private static final long serialVersionUID = -5053537955090445275L;
	
	public Class<?> objectClass;
	
	public ConflictException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ConflictException(String message) {
	    super(message);
	}
	
	/**
	 * The class of the object that was not found. Contains the
	 * interface-class of the activiti-object that was not found.
	 */
	public Class<?> getObjectClass() {
		return objectClass;
	}
}