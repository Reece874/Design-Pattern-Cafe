package model;

public class BBQSauce extends spiceDecorator{
	
	Meat meat; 
	
	public BBQSauce(Meat meat) {
		this.meat = meat; 
	}

	@Override
	public String getRecepie() {
		return meat.getRecepie() + "-Glaze with BBQ Sauce\n"; 
	}

	@Override
	public String getDesc() {
		return meat.getDesc() + " With BBQ Sauce";
	}
	
	@Override
	public double getCost() {
		return (meat.getCost() + (0.99 * meat.getQuantity()));
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
