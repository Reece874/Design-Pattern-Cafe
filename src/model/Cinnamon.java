package model;

public class Cinnamon extends spiceDecorator{
	
	Meat meat; 
	
	public Cinnamon(Meat meat) {
		this.meat = meat; 
	}

	@Override
	public String getRecepie() {
		return meat.getRecepie() + "-Sprinkle Cinnamon\n"; 
	}

	@Override
	public String getDesc() {
		return meat.getDesc() + " With Cinnamon";
	}
	
	@Override
	public double getCost() {
		return Math.round(100.0 * ((meat.getCost() + (0.79 * meat.getQuantity()))))/100.0;
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
