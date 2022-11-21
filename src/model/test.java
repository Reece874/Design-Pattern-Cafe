package model;

import java.lang.reflect.InvocationTargetException;

public class test {

	public static void main(String[] args) {
//		Order order = new Order(); 
//		Kitchen kitchen = Kitchen.getKitchen();
//		MasterList.getList();
//		order.setMeatType("Beef");
//		order.setCookingMethod("Roast");
//		order.setAmount(3);
//		System.out.println(order.getDesc());
//		MasterList.getList().addOrder(order);
//		MasterList.getList().displayMaster();
//		kitchen.completeOrder(0);
//		MasterList.getList().displayMaster();
		
		OrderFactory of = new OrderFactory(); 
		try {
			of.setMeatType("Beef");
			of.setCook("Roast");
			//System.out.println(of.getDesc());
			Meat m = of.getFood(); 
			
			of.setMeatType("Salmon");
			of.setCook("Grill");
			of.addSeasoning("Cumin");
			of.addSeasoning("BBQSauce");
			Meat m2 = of.getFood(); 
			
			System.out.println(m.getDesc());
			System.out.println(m2.getDesc());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		


	}

}
