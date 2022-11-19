package model;

public class Beef extends Meat{
	
	public Beef() {
		setCookMethod(new Roast());
		setMeatType("Beef");
		setQuantity(1);
	}
	
	public Beef(CookMethod cm, int qty) {
		setCookMethod(cm);
		setMeatType("Beef");
		setQuantity(qty);
	}

	@Override
	public String getRecepie() {
		return performCook();
	}

	@Override
	public String getDesc() {
		return Quantity  + " Order(s) of Beef" + cookmethod.desc();
	}

	@Override
	public double getCost() {
		return (14.99 + cookmethod.getCost()) * Quantity;
	}

}
