package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MasterList {
	
	private static ObservableList<Order> orders; 
	private static MasterList masterList; 
	private PropertyChangeSupport support;
	
	public void displayMaster() {
		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i).getDesc() + " " + orders.get(i).getStatus());
		}
	}
	
	private MasterList() {
		orders = FXCollections.observableArrayList();
		support = new PropertyChangeSupport(this);
	}
	
	public static MasterList getList() {
		if(masterList == null) {
			masterList = new MasterList(); 
		}
		return masterList;
	}
	
	public ObservableList<Order> getFullList(){
		return orders; 
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
	
	public void addOrder(Order order) {
		try {
			Order o = (Order)order.Clone(); 
			orders.add(o);
			support.firePropertyChange(o.getDesc() + " has been ordered!", orders, o);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	public void displayList() {
		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i).getDesc());
		}
	}

}
