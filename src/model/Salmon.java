package model;

public class Salmon extends Meat{

	public Salmon() {
		setMeatType("Salmon");
		setQuantity(1);
	}
	
	public Salmon(CookMethod cm, int qty) {
		setCookMethod(cm);
		setMeatType("Salmon");
		setQuantity(qty);
	}
	
	@Override
	public String getDesc() {
		StringBuilder sb = new StringBuilder(Quantity  + " Order(s) of Salmon ");
		if(cookmethod != null) {
			sb.append(cookmethod.desc());
		}
		return sb.toString();
	}
	
	@Override
	public double getCost() {
		return (cookmethod == null)? 0 : Math.round(100.0 * ((15.99 + cookmethod.getCost()) * Quantity))/100.0;
	}

}
