package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

public class Kitchen implements PropertyChangeListener{
	
	private static Kitchen kitchen = new Kitchen();
	private LinkedList<Order> Todo; 
	private PropertyChangeSupport support;
	
	private Kitchen() {
		MasterList.getList().addPropertyChangeListener(this);
		Todo = new LinkedList<>();
		support = new PropertyChangeSupport(this);
	}
	
	public static Kitchen getKitchen() {
		return kitchen; 
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}
	
	public void completeOrder(int i) {
		if(Todo.size() > 0) {
		Order o = Todo.remove(i);
		o.setStatus("Fulfilled");
		MasterList.getList().displayMaster();
		support.firePropertyChange(o.getDesc() + " Has been completed", null, null);
		}
	}
	
	public String getRecepie(int pos) {
		if(pos >= Todo.size()) {
			return "No Orders"; 
		}
		return Todo.get(pos).getRecepie(); 
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Todo.add((Order)evt.getNewValue());
	}
	
	
	public void displayList() {
		for (int i = 0; i < Todo.size(); i++) {
			System.out.println(Todo.get(i).getDesc());
		}
	}
	

}
