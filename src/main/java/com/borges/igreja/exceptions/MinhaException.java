package com.borges.igreja.exceptions;

import javax.persistence.EntityExistsException;

public class MinhaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4980343448777726366L;
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public MinhaException(String string, EntityExistsException e) {
		
	}

}
