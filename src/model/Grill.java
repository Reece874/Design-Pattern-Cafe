package model;

public class Grill implements CookMethod{

	@Override
	public String cook(int amt, String type) {
		String recepie = "-Place " + amt + " " + type + " cuts on a grill.\n"
				+ "-Grill cuts for about 10 mins or until grill lines appear\n"
				+ "-Flip cut and let grill for another 10 mins\n"
				+ "-Remove " + type + " cuts from grill.\n";
		return recepie; 	
	}
	
	@Override
	public String desc() {
		return " Grilled";
	}
	
	@Override
	public double getCost() {
		return 4.99;
	}

}
