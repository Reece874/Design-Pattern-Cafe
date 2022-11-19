package model;

public class Fry implements CookMethod{

	@Override
	public String cook(int amt, String food) {
		String recepie = "-Fill a deep plate with " + Math.ceil(amt * .3) + " cups of flour\n"
				+ "-Fill another deep plate with " + Math.ceil(amt * .4) + " eggs\n"
				+ "-Scramble the eggs\n"
				+ "-For each cut of " + food + " cover the cut in eggs, then coat in flour\n"
				+ "-Place all cuts in the fryer for about 5 mins\n"
				+ "-Let " + food + " sit for an additional 10 mins\n";
		return recepie;
	}
	
	@Override
	public String desc() {
		return " Fried";
	}
	
	@Override
	public double getCost() {
		return 3.99;
	}

}
