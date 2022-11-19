package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import model.Kitchen;
import model.MasterList;

public class ChefController implements PropertyChangeListener, Initializable{
	
	@FXML
	private TextArea TAalerts;
	
	@FXML
	private TextArea TAOrder;
	
	public void Clear() {
		TAalerts.setText("");
	}
	
	public void Completed() {
		Kitchen.getKitchen().completeOrder(0);
		TAOrder.setText(Kitchen.getKitchen().getRecepie(0));
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		TAalerts.setText(TAalerts.getText() + evt.getPropertyName()  + "\n");
		TAOrder.setText(Kitchen.getKitchen().getRecepie(0));
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MasterList.getList().addPropertyChangeListener(this);
		TAOrder.setText(Kitchen.getKitchen().getRecepie(0));
		
	}

}
