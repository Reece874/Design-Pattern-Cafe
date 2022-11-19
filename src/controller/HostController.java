package controller;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Kitchen;
import model.MasterList;
import model.Order;

public class HostController implements Initializable, PropertyChangeListener{
	
	@FXML
	private TableView<Order> Table; 
	
	@FXML 
	private TableColumn<Order, String> Col1;
	
	@FXML 
	private TableColumn<Order, Double> Col2;
	
	@FXML 
	private TableColumn<Order, String> Col3;
	
	@FXML
	private TextArea TAalerts; 
	
	public void Clear() {
		TAalerts.setText("");
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		Kitchen.getKitchen().addPropertyChangeListener(this);
		MasterList.getList().addPropertyChangeListener(this);
		Col1.setCellValueFactory(new PropertyValueFactory<>("Desc"));
		Col2.setCellValueFactory(new PropertyValueFactory<>("Cost"));
		Col3.setCellValueFactory(new PropertyValueFactory<>("Status"));
		Table.setItems(MasterList.getList().getFullList());
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		TAalerts.setText(TAalerts.getText()+ evt.getPropertyName() + "\n");
		if(evt.getOldValue() == null) {
			Table.refresh();
		}
		
	}


}
