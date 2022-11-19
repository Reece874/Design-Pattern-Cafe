package model;

public class Pork extends Meat{
	
	public Pork() {
		setCookMethod(new Grill());
		setMeatType("Pork");
		setQuantity(1);
	}
	
	public Pork(CookMethod cm,  int qty) {
		setCookMethod(cm);
		setMeatType("Pork");
		setQuantity(qty);
	}

	@Override
	public String getRecepie() {
		return performCook();
	}
	
	@Override
	public String getDesc() {
		return Quantity  + " Order(s) of Pork" + cookmethod.desc();
	}
	
	@Override
	public double getCost() {
		return (13.99 + cookmethod.getCost()) * Quantity;
	}

}
