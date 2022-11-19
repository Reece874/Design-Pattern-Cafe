package model;

public class Salmon extends Meat{

	public Salmon() {
		setCookMethod(new Grill());
		setMeatType("Salmon");
		setQuantity(1);
	}
	
	public Salmon(CookMethod cm, int qty) {
		setCookMethod(cm);
		setMeatType("Salmon");
		setQuantity(qty);
	}

	@Override
	public String getRecepie() {
		return performCook();
	}
	
	@Override
	public String getDesc() {
		return Quantity  + " Order(s) of Salmon" + cookmethod.desc();
	}
	
	@Override
	public double getCost() {
		return (15.99 + cookmethod.getCost()) * Quantity;
	}

}
