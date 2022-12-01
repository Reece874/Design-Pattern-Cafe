package model;

import java.lang.reflect.InvocationTargetException;

public class OrderFactory {
	
	private Order order;
	private Meat food;
	
	public OrderFactory() {
		order = new Order();
	}
	
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
	
	public double getOrderCost() {
		return order.getCost();
	}
	
	public String getRecepit() {
		return order.getReciept();
	}
	
	public void addToOrder() {
		Meat f = food; 
		food = null; 
		order.add(f);
	}
	
	public Order getOrder() {
		Order o = order; 
		order = new Order(); 
		return o;
	}
	
	public boolean isOrderEmpty() {
		if(order == null) {
			return true; 
		}
		return false;
	}
	
	

}
