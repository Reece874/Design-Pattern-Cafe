package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import model.Disabler;
import model.InfoDisplays;
import model.MasterList;
import model.Order;

public class ViewController implements Initializable{
	Order order; 
	
	@FXML
	private RadioButton RadioBeef;
	
	@FXML
	private RadioButton RadioChicken; 
	
	@FXML
	private RadioButton RadioSalmon; 
	
	@FXML
	private RadioButton RadioPork; 
	
	@FXML
	private RadioButton RadioGrill;
	
	@FXML
	private RadioButton RadioRoast;
	
	@FXML
	private RadioButton RadioBoil; 
	
	@FXML
	private RadioButton RadioFry; 
	
	@FXML
	private ToggleGroup Meat; 
	
	@FXML
	private ToggleGroup Cook; 
	
	@FXML
	private Button BtnBBQ; 
	
	@FXML
	private Button BtnCin; 
	
	@FXML
	private Button BtnCumin;
	
	@FXML
	private Label OrderDetails;
	
	@FXML
	private Label LblPrice; 
	
	@FXML
	private Spinner<Integer> SpinnerAmt;
	
	public void PlaceOrder() {
		if(Meat.getSelectedToggle() == null || Cook.getSelectedToggle() == null) {
			InfoDisplays.displayGenericInformation("Something is not Selected");
			return;
		}else {
			MasterList.getList().addOrder(order);
			InfoDisplays.displayGenericInformation("Your order has been placed.  Total: $" + order.getCost());
			Clear();
		}
	}
	
	public void Clear() {
		SpinnerAmt.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1, 1));
		SpinnerAmt.setDisable(true);
		Meat.getSelectedToggle().setSelected(false);
		Cook.getSelectedToggle().setSelected(false);
		Disabler.getInstance().enableAll();	
		OrderDetails.setText("Order Details:");
		LblPrice.setText("Cost:");
		order.clear();
	}
	
	public void addBBQ() {
		if(order.getOrderVal()) {
		order.addBBQ();
		Disabler.getInstance().disableButton(BtnBBQ);
		OrderDetails.setText("Order Details: " + order.getDesc());
		LblPrice.setText("Cost: $" + order.getCost());
		}
	}
	
	public void addCin() {
		if(order.getOrderVal()) {
		order.addCin();
		Disabler.getInstance().disableButton(BtnCin);
		OrderDetails.setText("Order Details: " + order.getDesc());
		LblPrice.setText("Cost: $" + order.getCost());
		}
	}
	
	public void addCumin() {
		if(order.getOrderVal()) {
		order.addCumin();
		Disabler.getInstance().disableButton(BtnCumin);
		OrderDetails.setText("Order Details: " + order.getDesc());
		LblPrice.setText("Cost: $" + order.getCost());
		}
	}
	
	public void disableSome(String Disable) {
		Disabler.getInstance().enableAll();
		
		switch(Disable) {
		case("Beef"):
			Disabler.getInstance().disableButton(RadioBoil);
			break;
		case("Salmon"):
			Disabler.getInstance().disableButton(BtnCin); 
			break;
		default:
			break;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		order = new Order(); 
		SpinnerAmt.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1, 1));
		SpinnerAmt.setDisable(true);
		
		RadioBeef.setUserData("Beef");
		RadioChicken.setUserData("Chicken");
		RadioSalmon.setUserData("Salmon");
		RadioPork.setUserData("Pork");
		RadioRoast.setUserData("Roast");
		RadioBoil.setUserData("Boil");
		RadioFry.setUserData("Fry");
		RadioGrill.setUserData("Grill");
		
		Meat.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

		         if (Meat.getSelectedToggle() != null) {
		             disableSome(Meat.getSelectedToggle().getUserData().toString());
		             order.setMeatType(Meat.getSelectedToggle().getUserData().toString());
		     		OrderDetails.setText("Order Details: " + order.getDesc());
		    		LblPrice.setText("Cost: $" + order.getCost());
		             SpinnerAmt.setDisable(false);
		         }
		     } 
		});
		
		Cook.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

		         if (Cook.getSelectedToggle() != null) {
		             order.setCookingMethod(Cook.getSelectedToggle().getUserData().toString());
		     		OrderDetails.setText("Order Details: " + order.getDesc());
		    		LblPrice.setText("Cost: $" + order.getCost());
		         }
		     } 
		});
		
		SpinnerAmt.valueProperty().addListener((obs, oldValue, newValue) -> order.setAmount(newValue));
		SpinnerAmt.valueProperty().addListener((obs, oldValue, newValue) -> OrderDetails.setText("Order Details: " + order.getDesc()));
		SpinnerAmt.valueProperty().addListener((obs, oldValue, newValue) -> LblPrice.setText("Cost: $" + order.getCost()));

	}
}
