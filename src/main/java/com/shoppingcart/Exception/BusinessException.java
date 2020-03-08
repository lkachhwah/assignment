package com.shoppingcart.Exception;

public class BusinessException extends Exception {

	public static final String DATA_VALIDATE_ISSUE = "100";
	public static final String DATA_MISSING_IN_DB = "101";
	private String message;
	private String code;
	
	public BusinessException (String message, String code) {
		super(message);
		
		// TODO Auto-generated constructor stub
	}
	
	public BusinessException(String message, String code, Throwable err) {
	    super(message, err);
	}
	
	public String getCode()
	{
		return code;
	}

}
