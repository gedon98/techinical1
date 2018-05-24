package tech.messageproc.controller;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import tech.messageproc.model.MessageType;

public class SalesLedgerControllerTest {
	
	@Test
	public void salesLedger10Sales() {
		SalesLedgerController controller = new SalesLedgerController();
		
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		
		assertTrue(controller.ledger != null);
		assertTrue(controller.ledger.ledgerSize() == 10); 
	}
	
	@Test
	public void salesLedgerOver50Sales() {
		SalesLedgerController controller = new SalesLedgerController();
		
		for (int i = 0; i < 100 ; i++) {
			controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
		}		
		assertTrue(controller.ledger != null);
		assertTrue(controller.ledger.ledgerSize() == 50); 
	}
	
	@Test
	public void salesMultiSalesLedgerOver50Sales() {
		SalesLedgerController controller = new SalesLedgerController();
		
		for (int i = 0; i < 100 ; i++) {
			controller.handleMessage(""+MessageType.Sales.toString()+",productA"+",5,1.10");
		}		
		assertTrue(controller.ledger != null);
		assertTrue(controller.ledger.ledgerSize() == 50); 
	}

	
	@Test
	public void salesMultiSalesMultiProductLedgerOver() {
		SalesLedgerController controller = new SalesLedgerController();
		
		for (int i = 0; i < 10 ; i++) {
			controller.handleMessage(""+MessageType.Sales.toString()+",productA"+",5,1.10");
			controller.handleMessage(""+MessageType.Sales.toString()+",productB"+",10,2.0");
		}		
		assertTrue(controller.ledger != null);
		assertTrue(controller.ledger.ledgerSize() == 20); 
	}
	
	
	@Test
	public void salesMultiSalesMultiProductLedgerWithAdjustment() {
		SalesLedgerController controller = new SalesLedgerController();
		
		for (int i = 0; i < 12 ; i++) {
			controller.handleMessage(""+MessageType.Sales.toString()+",productA"+",5,1.10");
			controller.handleMessage(""+MessageType.Sales.toString()+",productB"+",10,2.0");
		}		
		
		controller.handleMessage(""+MessageType.Adjustment.toString()+",productB,+,1.0");
		
		for (int i = 0; i < 20 ; i++) {
			controller.handleMessage(""+MessageType.Sales.toString()+",productA"+",5,1.10");
			controller.handleMessage(""+MessageType.Sales.toString()+",productB"+",10,2.0");
		}	
		
		assertTrue(controller.ledger != null);
		assertTrue(controller.ledger.ledgerSize() == 50); 
	}

}
