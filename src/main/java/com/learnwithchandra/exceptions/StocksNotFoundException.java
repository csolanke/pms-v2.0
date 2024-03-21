package com.learnwithchandra.exceptions;

public class StocksNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public StocksNotFoundException(String msg)
	{
		super(msg);
	}

}
