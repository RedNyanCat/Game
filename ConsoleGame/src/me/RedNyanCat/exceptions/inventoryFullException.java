package me.RedNyanCat.exceptions;

public class inventoryFullException extends Exception {

	private static final long serialVersionUID = 1L;

	public inventoryFullException(String message) {
		
		super("Inventory is full, cannot continue. " + message);
		
	}
	
}
