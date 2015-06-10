package com.fonxian.Model;

import java.lang.*;

public class ClassException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClassException(){
		super();
	}
	
	public ClassException(String message,Throwable cause){
		super(message,cause);
	}
	
	public ClassException(String message){
		super(message);
	}
	
	public ClassException(Throwable cause){
		super(cause);
	}

}
