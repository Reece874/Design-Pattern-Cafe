package model;

import java.util.LinkedList;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.RadioButton;

public class Disabler {
	private LinkedList<ButtonBase> disabled; 
	private static Disabler disable; 
	
	public static Disabler getInstance() {
		if(disable == null) {
			disable = new Disabler(); 
		}
		return disable; 
	}
	
	private Disabler() {
		disabled = new LinkedList<>();
	}
	
	public void disableButton(RadioButton radio) {
		radio.setSelected(false);
		radio.setDisable(true);
		disabled.add(radio); 
	}
	
	public void disableButton(Button button) {
		button.setDisable(true);
		//disabledSpice.add(button);
		disabled.add(button); 
	}
	
	public void enableAll() {
		for (int i = disabled.size(); i > 0 ; i--) {
			disabled.remove().setDisable(false);
		}
	}

}
