package model;

import java.util.LinkedList;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class Disabler {
	private LinkedList<RadioButton> disabledCook;
	private LinkedList<Button> disabledSpice;
	private static Disabler disable; 
	
	public static Disabler getInstance() {
		if(disable == null) {
			disable = new Disabler(); 
		}
		return disable; 
	}
	
	private Disabler() {
		disabledCook = new LinkedList<>();
		disabledSpice = new LinkedList<>();
	}
	
	public void disableButton(RadioButton radio) {
		radio.setSelected(false);
		radio.setDisable(true);
		disabledCook.add(radio); 
	}
	
	public void disableButton(Button button) {
		button.setDisable(true);
		disabledSpice.add(button);
	}
	
	public void enableAll() {
		for (int i = disabledCook.size(); i > 0 ; i--) {
			disabledCook.remove().setDisable(false);
		}
		for (int i = disabledSpice.size(); i > 0 ; i--) {
			disabledSpice.remove().setDisable(false);
		}
	}

}
