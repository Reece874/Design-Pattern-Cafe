package model;

public class Chicken extends Meat{
	
	public Chicken() {
		setCookMethod(new Grill());
		setMeatType("Chicken");
		setQuantity(1);
	}
	
	public Chicken(CookMethod cm, int qty) {
		setCookMethod(cm);
		setMeatType("Chicken");
		setQuantity(qty);
	}

	@Override
	public String getRecepie() {
		return performCook();
	}
	
	@Override
	public String getDesc() {
		return Quantity  + " Order(s) of Chicken" + cookmethod.desc();
	}
	
	@Override
	public double getCost() {
		return (12.99 + cookmethod.getCost()) * Quantity;
	}

}
