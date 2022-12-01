package model;

import java.util.LinkedList;

public class Order {
	private LinkedList<Item> order; 
	private String Status; 
	
	public Order() {
		order = new LinkedList<>();
		Status = "Incomplete";
	}
	
	public void add(Item item) {
		order.add(item);
	}
	
	public double getCost() {
		double x = 0; 
		for(Item item : order) {
			x+=item.getCost();
		}
		return x; 
	}
	
	public String getItemDesc() {
		StringBuilder desc = new StringBuilder();
		for(Item item : order) {
			desc.append(item.getDesc() + ", ");
		}
		String d = desc.toString();
		return d.substring(0, d.lastIndexOf(','));
	}
	
	public String getFullOrderRecepie() {
		StringBuilder desc = new StringBuilder();
		for(Item item : order) {
			desc.append("\n---ITEM---\n" + item.getRecepie() + "\n");
		}
		return desc.toString();
	}
	
	public String getReciept() {
		StringBuilder desc = new StringBuilder();
		for(Item item : order) {
			desc.append(item.getReceipt() + "\n");
		}
		desc.append("-----------------------Total-----------------------\n");
		desc.append(getCost());
		return desc.toString();
	}
	
	public void setStatus(String status) {
		this.Status = status; 
	}
	
	public String getStatus() {
		return Status; 
	}

}
