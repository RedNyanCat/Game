package me.RedNyanCat.data;

import java.util.ArrayList;
import java.util.List;

import me.RedNyanCat.entities.entity;

public class saved_class {
	
	private List<entity> entities = new ArrayList<entity>();; //getter + setter
	
	public saved_class(List<entity> entities) {
		
		this.entities = entities;
		
	}
	
	//setters
	
	public void addToSavedEntities(entity e) {
		
		entities.add(e);
		
	}
	
	//getters
	
	public List<entity> getSavedEntities() {
		
		return entities;
		
	}
	
}
