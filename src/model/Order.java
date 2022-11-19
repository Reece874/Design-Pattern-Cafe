package model;

public class Order implements Cloneable{
	
	private Meat food; 
	private CookMethod cm;
	private String Status;
	
	public Order() {
		Status = "Incomplete"; 
	}
	
	public boolean getOrderVal() {
		if(food == null) {
			return false;
		}
		return true;
	}
	
	public void clear() {
		food = null;
		cm = null;
	}
	
	public void setStatus(String status) {
		this.Status = status; 
	}
	
	public String getStatus() {
		return Status; 
	}
	
	public void addBBQ() {
		if(food != null) {
			food = new BBQSauce(food);
		}	
	}
	
	public void addCin() {
		if(food != null) {
			food = new Cinnamon(food);
		}	
	}
	
	public void addCumin() {
		if(food != null) {
			food = new Cumin(food);
		}	
	}
	
	public void setMeatType(String meat) {
		switch(meat) {
		case("Beef"):
			food = new Beef(); 
			break; 
		case("Chicken"):
			food = new Chicken();
			break; 
		case("Salmon"):
			food = new Salmon();
			break; 
		default:
			food = new Pork(); 
			break; 
		}
	}
	
	public void setCookingMethod(String cook) {
		switch(cook) {
		case("Roast"):
			cm = new Roast(); 
			break; 
		case("Boil"):
			cm = new Boil(); 
			break; 
		case("Fry"):
			cm = new Fry(); 
			break; 
		default:
			cm = new Grill(); 
			break; 
		}
	}
	
	public void setAmount(int amt) {
		food.setQuantity(amt);
	}
	
	public String getDesc() {
		if(food != null && cm != null) {
			food.setCookMethod(cm);
			return food.getDesc();
		}
		return "";
	}
	
	public double getCost() {
		if(food != null && cm != null) {
			food.setCookMethod(cm);
			return Math.round(100.0 * food.getCost())/100.0; 
		}
		return 0;
	}
	
	public String getRecepie() {
		return food.getRecepie();
	}
	
	public Object Clone() throws CloneNotSupportedException{
		Order o = (Order)super.clone(); 
		o = new Order(); 
		o.food = food; 
		o.cm = cm; 
		return o; 
	}

}
