package me.RedNyanCat.exceptions;

public class alreadyDeadException extends Exception{

	private static final long serialVersionUID = 1L;

	public alreadyDeadException(String message) {
		
		super("Entity already dead. " + message);
		
	}
	
}
