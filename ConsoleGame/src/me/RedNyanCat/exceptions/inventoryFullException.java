package me.RedNyanCat.exceptions;

public class inventoryFullException extends Exception {

	public inventoryFullException(String message) {
		
		super("Inventory is full, cannot continue. " + message);
		
	}
	
}
