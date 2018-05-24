package tech.messageproc.model.payload;

import tech.messageproc.model.operations.AdjustmentOperationFactory;
import tech.messageproc.model.operations.OperationType;

public class AdjustmentMessagePayload {
	private String productId;
	private OperationType operation;
	
	public AdjustmentMessagePayload(String productId, OperationType operation) {
		this.setProductId(productId);
		this.operation = operation;
	}
	
	public AdjustmentMessagePayload(String[] params) {
		productId = params[1];
		operation = AdjustmentOperationFactory.getAdjustmentOperation(params[2], Double.valueOf(params[3]));
	}
	
	public OperationType getOperation() {
		return operation;
	}
	public void setOperation(OperationType operation) {
		this.operation = operation;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}
