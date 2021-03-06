package tech.messageproc.model.operations;

public class MultiplyAdjustmentOperation implements OperationType {
	
	double value = 0;

	public double performOperation(double startValue) {
		return startValue * value;
	}

	public double getAdjustmentValue() {
		return value;
	}

	public void setAdjustmentValue(double value) {
		this.value = value;
	}
	
	public String toString() {
		return "Adustment multiply by value :"+value;
	}
}
