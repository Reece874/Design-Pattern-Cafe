package model;

import java.lang.reflect.InvocationTargetException;

public class OrderFactory {
	
	private Meat food; 
	
	public void setMeatType(String meat) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class<?> clazz = Class.forName("model." + meat);	
		food = (Meat)clazz.getDeclaredConstructor().newInstance();		
	}
	
	public void setCook(String cook) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		if(food != null) {
		Class<?> clazz = Class.forName("model." + cook);	
		food.setCookMethod((CookMethod)clazz.getDeclaredConstructor().newInstance());	
		}
	}
	
	public boolean addSeasoning(String Season) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		if(food != null) {
			Class<?> clazz = Class.forName("model." + Season);	
			food = (Meat)clazz.getDeclaredConstructor(Meat.class).newInstance(food);
			return true; 
		}	
		return false;
	}
	
	public void setAmount(int amt) {
		if(food != null) {
		food.setQuantity(amt);
		}
	}
	
	public String getDesc() {
		if(food != null) {
			return food.getDesc();
		}
		return "";
	}
	
	public double getCost() {
		if(food != null) {
			return RoundCost.roundCost(food.getCost());
		}
		return 0;
	}
	
	public Meat getFood() {
		Meat f = food; 
		food = null; 
		f.setStatus("Incompleted");
		return f;
		
	}

}
