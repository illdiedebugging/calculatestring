package com.illdiedebugging.calculatestring;

public class UnableToCalculateException extends Exception{
	private static final long serialVersionUID = 1L;

	public UnableToCalculateException (String s){
		super(s);
	}
}
