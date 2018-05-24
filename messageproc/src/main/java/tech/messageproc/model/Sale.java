package tech.messageproc.model;

import java.util.ArrayList;
import java.util.List;

import tech.messageproc.model.operations.OperationType;

public class Sale {
	private String productId;
	private int quantity;
	private List<OperationType> adjustments = new ArrayList<OperationType>();	
	
	public Sale(String productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;				
	}
	
	public Sale(String productId, int quantity, double unitPrice) {
		this.productId = productId;
		this.quantity = quantity;	
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void addAdjustment(OperationType operation) {
		adjustments.add(operation);
	}
	
	public List<OperationType> getAllAdjustments() {
		return adjustments;
	}
	
}
