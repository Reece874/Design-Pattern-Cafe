package model;

public class Roast implements CookMethod{

	@Override
	public String cook(int amt, String type) {
		String recepie = "-Place a " + amt + "ibs. " + type + " in a pot.\n"
				+ "-place roast in pan and at 275 f Sear all sides for about 15 mins total\n"
				+ "-Remove roast from pan, glaze the roast with butter and place back in pan\n"
				+ "-Place roast in over for about " + (amt * 15) + " mins until the center of the roast is 130 f\n"
				+ "-Remove " + type + " from oven and cut into" + (amt * 5) + " slices.\n";
		return recepie; 
		
	}
	
	@Override
	public String desc() {
		return " Roasted";
	}
	
	@Override
	public double getCost() {
		return 7.99;
	}

}
