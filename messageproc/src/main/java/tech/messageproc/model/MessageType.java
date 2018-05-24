package tech.messageproc.model;

public enum MessageType {
	SingleSale("1"), Sales("2"), Adjustment("3");
	
	String id;
	
	MessageType(String id) {
		this.id = id;
	}
	
}
