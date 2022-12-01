package model;

public abstract class Meat implements Item{
	protected CookMethod cookmethod; 
	protected int Quantity; 
	private String type;  
	
	public Meat() {
		type = "Meat"; 
	}
	
	public void setQuantity(int amt) {
		Quantity = amt; 
	}
	
	public int getQuantity() {
		return Quantity;
	}
	
	public void setMeatType(String type) {
		this.type = type; 
	}
	
	public void setCookMethod(CookMethod cookmethod) {
		this.cookmethod = cookmethod; 
	}
	
	public String performCook() {
		return cookmethod.cook(Quantity, type);
	}
	
	public String getRecepie() {
		return performCook();
	}
	
	public String getReceipt() {
		return getDesc() + ": $" + getCost();
	}
	
	public abstract String getDesc(); 
	public abstract double getCost();
	
}
