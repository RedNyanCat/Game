package me.RedNyanCat.data;

public class item {

	private int maxStack = 24; //getter + protected setter
	private int stack = 1; //getter + setter
	
	itemType iType = itemType.NULL; //getter
	
	public item(int stack, itemType iType) {
		
		this.stack = stack;
		this.iType = iType;
		
	}
	
	//getters
	
	public int getMaxStack() {
		
		return maxStack;
		
	}
	
	public int getStackAmount() {
		
		return stack;
		
	}
	
	public itemType getIType() {
		
		return iType;
		
	}
	
	//setters
	
	public void setStackAmount(int amount) {
		
		stack = amount;
		
	}
	
	protected void setMaxItemStackAmount(int amount) {
		
		maxStack = amount;
		
	}
	
}
