package model;

public class Beef extends Meat{
	
	public Beef() {
		setMeatType("Beef");
		setQuantity(1);
	}
	
	public Beef(CookMethod cm, int qty) {
		setCookMethod(cm);
		setMeatType("Beef");
		setQuantity(qty);
	}

	@Override
	public String getDesc() {
		StringBuilder sb = new StringBuilder(Quantity  + " Order(s) of Beef ");
		if(cookmethod != null) {
			sb.append(cookmethod.desc());
		}
		return sb.toString();
	}

	@Override
	public double getCost() {
		return (cookmethod == null)? 0 : Math.round(100.0 * ((14.99 + cookmethod.getCost()) * Quantity))/100.0;
	}

}
