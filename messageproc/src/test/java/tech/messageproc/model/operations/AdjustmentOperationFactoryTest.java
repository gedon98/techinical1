package tech.messageproc.model.operations;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AdjustmentOperationFactoryTest {
	
	@Test
	public void factoryResults () {
		OperationType operationType = AdjustmentOperationFactory.getAdjustmentOperation("+", 0.2);
		assertTrue("Null operation returned for add operation", operationType != null);
		assertTrue("Incorrect operation type returned for add", operationType instanceof AddAdjustmentOperation);
		
		operationType = AdjustmentOperationFactory.getAdjustmentOperation("-", 0.2);
		assertTrue("Null operation returned for subtract operation", operationType != null);
		assertTrue("Incorrect operation type returned for subtract", operationType instanceof SubtractAdjustmentOperation);
		
		operationType = AdjustmentOperationFactory.getAdjustmentOperation("*", 0.2);
		assertTrue("Null operation returned for multiply operation", operationType != null);
		assertTrue("Incorrect operation type returned for multiply", operationType instanceof MultiplyAdjustmentOperation);
		
		operationType = AdjustmentOperationFactory.getAdjustmentOperation("/", 0.2);
		assertTrue("Null operation returned for divide operation", operationType != null);
		assertTrue("Incorrect operation type returned for divide", operationType instanceof DivideAdjustmentOperation);
		
		operationType = AdjustmentOperationFactory.getAdjustmentOperation("A", 0.2);
		assertTrue("Non null operation returned for add operation", operationType == null);
	}
	
	@Test
	public void addAdjustmentTest() {
		OperationType operationType = AdjustmentOperationFactory.getAdjustmentOperation("+", 0.2);
		double startValue = 10.0;
		
		assertTrue("Add operation expected 10.2 got:"+operationType.performOperation(startValue), operationType.performOperation(startValue) == 10.2);
	}
	
	@Test
	public void minusAdjustmentTest() {
		OperationType operationType = AdjustmentOperationFactory.getAdjustmentOperation("-", 0.2);
		double startValue = 10.0;
		
		assertTrue("Add operation expected 9.8 got:"+operationType.performOperation(startValue),operationType.performOperation(startValue) == 9.8);
	}
		
	@Test
	public void multiplyAdjustmentTest() {
		OperationType operationType = AdjustmentOperationFactory.getAdjustmentOperation("*", 2);
		double startValue = 10.0;
		
		assertTrue("Add operation expected 20.0 got:"+operationType.performOperation(startValue),operationType.performOperation(startValue) == 20.0);
	}
	
	@Test
	public void divideAdjustmentTest() {
		OperationType operationType = AdjustmentOperationFactory.getAdjustmentOperation("/", 2);
		double startValue = 10.0;
		
		assertTrue("Add operation expected 5.0 got:"+operationType.performOperation(startValue),operationType.performOperation(startValue) == 5.0);
	}	
}
