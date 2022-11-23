package model;

import java.lang.reflect.InvocationTargetException;

import javafx.scene.control.Button;

public class AddSpice {
	
	public static void addSeasoning(OrderFactory of, String season, Button button) {
		try {
			of.addSeasoning(season);
			Disabler.getInstance().disableButton(button);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
