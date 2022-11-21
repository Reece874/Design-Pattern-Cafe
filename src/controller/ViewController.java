package controller;

import java.lang.reflect.InvocationTargetException;
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
import model.OrderFactory;

public class ViewController implements Initializable{ 
	
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
	
	private OrderFactory of; 
	
	public void PlaceOrder() {
		if(Meat.getSelectedToggle() == null || Cook.getSelectedToggle() == null) {
			InfoDisplays.displayGenericInformation("Something is not Selected");
			return;
		}else {
			InfoDisplays.displayGenericInformation("Your order has been placed.  Total: $" + of.getCost());
			MasterList.getList().addOrder(of.getFood());
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
	}
	
	public void addBBQ() {
		try {
			of.addSeasoning("BBQSauce");
			Disabler.getInstance().disableButton(BtnBBQ);
			OrderDetails.setText("Order Details: " + of.getDesc());
			LblPrice.setText("Cost: $" + of.getCost());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addCin() {
		try {
			of.addSeasoning("Cinnamon");
			Disabler.getInstance().disableButton(BtnCin);
			OrderDetails.setText("Order Details: " + of.getDesc());
			LblPrice.setText("Cost: $" + of.getCost());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addCumin() {
		try {
			of.addSeasoning("Cumin");
			Disabler.getInstance().disableButton(BtnCumin);
			OrderDetails.setText("Order Details: " + of.getDesc());
			LblPrice.setText("Cost: $" + of.getCost());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
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
		of = new OrderFactory(); 
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
		             try {
						of.setMeatType(Meat.getSelectedToggle().getUserData().toString());
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		     		OrderDetails.setText("Order Details: " + of.getDesc());
		    		LblPrice.setText("Cost: $" + of.getCost());
		             SpinnerAmt.setDisable(false);
		         }
		     } 
		});
		
		Cook.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

		         if (Cook.getSelectedToggle() != null) {
		             try {
						of.setCook(Cook.getSelectedToggle().getUserData().toString());
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		     		OrderDetails.setText("Order Details: " + of.getDesc());
		    		LblPrice.setText("Cost: $" + of.getCost());
		         }
		     } 
		});
		
		SpinnerAmt.valueProperty().addListener((obs, oldValue, newValue) -> of.setAmount(newValue));
		SpinnerAmt.valueProperty().addListener((obs, oldValue, newValue) -> OrderDetails.setText("Order Details: " + of.getDesc()));
		SpinnerAmt.valueProperty().addListener((obs, oldValue, newValue) -> LblPrice.setText("Cost: $" + of.getCost()));

	}
}
