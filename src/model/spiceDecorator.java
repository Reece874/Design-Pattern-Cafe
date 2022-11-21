package model;

public abstract class spiceDecorator extends Meat{
	public abstract String getRecepie(); 
	public abstract String getDesc(); 
	public abstract void setQuantity(int amt);
	public abstract void setCookMethod(CookMethod cookmethod);
	public abstract int getQuantity();
	public abstract String getStatus();	
	public abstract void setStatus(String status);
	

}
