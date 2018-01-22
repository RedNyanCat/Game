package me.RedNyanCat.entities;

import me.RedNyanCat.data.inventory;
import me.RedNyanCat.exceptions.alreadyDeadException;
import me.RedNyanCat.main.game;

public class entity {

	//Inventory
	
	inventory inv = new inventory(12); //getter
	
	//Health
	private double health = 50, maxHealth = health; //getter + setter
	private double healthLevelMultiplier = 1.25; //setter
	
	protected boolean isDead = false; //neither
	
	//Leveling
	private double exp = 0; //getter + setter
	private int level = 1; //getter + setter
	private int maxLevel = 100; //neither
	private double expForNextLevel = (((500) * (level + 1)) * 2) - 25; //neither
	
	//Damage
	private double maxDamage = 10; //getter + setter
	
	//Entity type
	private entityType eType; //getter
	
	public entity(double health, double healthMulti, double exp, int level, double damage, entityType eType) {
		
		this.health = health;
		this.healthLevelMultiplier = healthMulti;
		this.exp = exp;
		this.level = level;
		this.maxDamage = damage;
		
		this.eType = eType;
		
		game.safeAddToSavedObjects(this);
		
	}
	
	//Other methods
	
	public void checkForLevelUp() {
		
		if((exp >= expForNextLevel) && (level < maxLevel)) {
			
			level++;
			exp -= expForNextLevel;
			
			maxDamage *= 2.25;
			maxHealth *= healthLevelMultiplier;
			
			return;
			
		}
		
	}
	
	public void damage(entity e, double damage) {
		
		e.setHealth(e.getHealth() - damage);
		
	}
	
	public void safeDeductHealth(double h) throws alreadyDeadException, NullPointerException {
		
		if(h > maxHealth && isDead) {
			
			isDead = true;
			health = 0;
						
		} else if (isDead) {
			
			throw new alreadyDeadException(this.getClass().toString());
			
		} else if (h <= maxHealth && !isDead) {
			
			health -= h;
						
		} else {
			
			isDead = true;
			health = 0;
			
			throw new NullPointerException(this.getClass().toString());
			
		}
		
	}
	
	public void safeRegenHealth(double h) throws alreadyDeadException {
		
		if(h > maxHealth && !isDead) {
			
			health = maxHealth;
						
		} else if (h <= maxHealth && !isDead) {
			
			health += h;
						
		} else {
			
			throw new alreadyDeadException(this.getClass().toString());
			
		}
		
	}
	
	//Setters
	
	public void setHealth(double h) {
		
		health = h;
		
	}
	
	public void setHealthLevelMultiplier(double m) {
		
		healthLevelMultiplier = m;
		
	}
	
	public void setExp(double e) {
		
		exp = e;
		
	}
	
	public void setLevel(int l) {
		
		level = l;
		
	}
	
	public void setDamageCap(double d) {
		
		maxDamage = d;
		
	}
	
	//Getters
	
	public inventory getInventory() {
		
		return inv;
		
	}
	
	public double getHealth() {
		
		return health;
		
	}
	
	public double getExp() {
		
		return exp;
		
	}
	
	public int getLevel() {
		
		return level;
		
	}
	
	public double getDamageCap() {
		
		return maxDamage;
		
	}
	
	public entityType getEType() {
		
		return eType;
		
	}
	
}
