package tech.messageproc.controller;

import org.junit.Test;

import tech.messageproc.model.MessageType;

public class SalesLedgerControllerTest {
	
	@Test
	public void salesLedger10Sales() {
		SalesLedgerController controller = new SalesLedgerController();
		
		controller.handleMessage(""+MessageType.SingleSale.toString()+",productA"+",5");
	}

}
