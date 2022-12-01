package model;

public class Chicken extends Meat{
	
	public Chicken() {
		setMeatType("Chicken");
		setQuantity(1);
	}
	
	public Chicken(CookMethod cm, int qty) {
		setCookMethod(cm);
		setMeatType("Chicken");
		setQuantity(qty);
	}
	
	@Override
	public String getDesc() {
		StringBuilder sb = new StringBuilder(Quantity  + " Order(s) of Chicken ");
		if(cookmethod != null) {
			sb.append(cookmethod.desc());
		}
		return sb.toString();
	}
	
	@Override
	public double getCost() {
		return (cookmethod == null)? 0 : Math.round(100.0 * ((12.99 + cookmethod.getCost()) * Quantity))/100.0;
	}

}
