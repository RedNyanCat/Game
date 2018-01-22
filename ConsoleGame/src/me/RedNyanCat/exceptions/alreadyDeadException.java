package me.RedNyanCat.exceptions;

public class alreadyDeadException extends Exception{

	public alreadyDeadException(String message) {
		
		super("Entity already dead. " + message);
		
	}
	
}
