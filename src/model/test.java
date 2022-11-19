package model;

public class test {

	public static void main(String[] args) {
		Order order = new Order(); 
		Kitchen kitchen = Kitchen.getKitchen();
		//MasterList.getList().addPropertyChangeListener(kitchen);
		order.setMeatType("Beef");
		order.setCookingMethod("Roast");
		System.out.println(order.getCost());
		order.setAmount(3);
		System.out.println(order.getCost());
		order.addBBQ();
		System.out.println(order.getCost());
		order.addCin();
		System.out.println(order.getCost());
		MasterList.getList().addOrder(order);
		//kitchen.displayMessages();
		MasterList.getList().addOrder(order);
		System.out.println();
		//kitchen.displayMessages();
		MasterList.getList().addOrder(order);
		System.out.println();
		//kitchen.displayMessages();
		System.out.println();
		kitchen.displayList();
	//	System.out.println(kitchen.getToDoSize());
		//MasterList.getList().di
		


	}

}
