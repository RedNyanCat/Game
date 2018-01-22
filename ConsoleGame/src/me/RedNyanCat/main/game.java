package me.RedNyanCat.main;

import java.util.ArrayList;

import me.RedNyanCat.data.saved_class;
import me.RedNyanCat.entities.entity;
import me.RedNyanCat.entities.entityType;

public class game {

	private static saved_class savedObjects = new saved_class(new ArrayList<entity>());
	
	public static void main(String[] args) {
		
		new game();
		
	}
	
	public game() {
		
		entity e = new entity(50.00, 1.25, 0.00, 1, 10.00, entityType.PLAYER);
		
		if(savedObjects != null) {
		
			debugging.print(savedObjects.getSavedEntities().toString());
		
		}
		
	}
	
	public static void safeAddToSavedObjects(entity e) {
		
		savedObjects.addToSavedEntities(e);
		
	}
	
}
