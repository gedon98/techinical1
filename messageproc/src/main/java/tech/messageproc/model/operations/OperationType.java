package tech.messageproc.model.operations;

public interface OperationType {
	
	public double getAdjustmentValue();
	public void setAdjustmentValue(double value);
	public double performOperation(double startValue);
	

}
