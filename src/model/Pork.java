package model;

public class Pork extends Meat{
	
	public Pork() {
		setMeatType("Pork");
		setQuantity(1);
	}
	
	public Pork(CookMethod cm,  int qty) {
		setCookMethod(cm);
		setMeatType("Pork");
		setQuantity(qty);
	}
	
	@Override
	public String getDesc() {
		StringBuilder sb = new StringBuilder(Quantity  + " Order(s) of Pork ");
		if(cookmethod != null) {
			sb.append(cookmethod.desc());
		}
		return sb.toString();
	}
	
	@Override
	public double getCost() {
		return (cookmethod == null)? 0 : Math.round(100.0 * ((13.99 + cookmethod.getCost()) * Quantity))/100.0;
	}

}
