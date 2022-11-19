package model;

public class Boil implements CookMethod{

	@Override
	public String cook(int amt, String type) {
		String recepie = "-Fill pot with about " + (amt *3) + " cups of water\n"
				+ "-Add some salt to the water\n"
				+ "-When the water reaches a rolling boil, place " + amt + " pieces of " + type + " into the pot\n"
				+ "-Let " + type + " boil for approximately 12 mins.\n"
				+ "-Remove " + type + " from water\n";
		return recepie;
	}

	@Override
	public String desc() {
		return " boiled";
	}
	
	@Override
	public double getCost() {
		return 2.99;
	}

}
