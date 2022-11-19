package model;

public class Cumin extends spiceDecorator{
	
	Meat meat; 
	
	public Cumin(Meat meat) {
		this.meat = meat; 
	}

	@Override
	public String getRecepie() {
		return meat.getRecepie() + "-Sprinkle Cumin\n"; 
	}

	@Override
	public String getDesc() {
		return meat.getDesc() + " With Cumin";
	}
	
	@Override
	public double getCost() {
		return (meat.getCost() + (0.59 * meat.getQuantity()));
	}

	@Override
	public void setQuantity(int amt) {
		meat.setQuantity(amt);
		
	}

	@Override
	public void setCookMethod(CookMethod cookmethod) {
		meat.setCookMethod(cookmethod);
		
	}
	
	@Override
	public int getQuantity() {
		return meat.getQuantity();
	}

}
