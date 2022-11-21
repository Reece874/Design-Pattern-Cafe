package model;

public abstract class Meat {
	protected CookMethod cookmethod; 
	protected int Quantity; 
	private String type;  
	private String status; 
	
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
	
	public String getStatus() {
		return status; 
	}
	
	public void setStatus(String status) {
		this.status = status; 
	}
	
	public abstract String getRecepie(); 
	public abstract String getDesc(); 
	public abstract double getCost();
	
}
