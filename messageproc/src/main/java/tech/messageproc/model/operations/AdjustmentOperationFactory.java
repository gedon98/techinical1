package tech.messageproc.model.operations;

public class AdjustmentOperationFactory {
	
	public static OperationType getAdjustmentOperation(String operator, double value) {
		if (operator.equals("+")) {
			OperationType type = new AddAdjustmentOperation();
			type.setAdjustmentValue(value);
			return type;
		}
		if (operator.equals("-")) {
			OperationType type =  new SubtractAdjustmentOperation();
			type.setAdjustmentValue(value);
			return type;
		}
		if (operator.equals("*")) {
			OperationType type =  new MultiplyAdjustmentOperation();
			type.setAdjustmentValue(value);
			return type;
		}
		if (operator.equals("/")) {
			OperationType type =  new DivideAdjustmentOperation();
			type.setAdjustmentValue(value);
			return type;
		}		
		return null;		
	}

}
