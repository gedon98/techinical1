package tech.messageproc.controller;

import tech.messageproc.model.MessageType;
import tech.messageproc.model.SalesLedger;
import tech.messageproc.model.payload.AdjustmentMessagePayload;
import tech.messageproc.model.payload.SaleMessagePayload;
import tech.messageproc.output.AdjustmentsPrinter;
import tech.messageproc.output.ProductTotalPrinter;

public class SalesLedgerController {
	private SalesLedger ledger = new SalesLedger();

	public void handleMessage(String inMessage) {
		String[] args = inMessage.split(",");
		try {
			MessageType type = MessageType.valueOf(args[0]);
			if (type == MessageType.SingleSale) {
				handleSale(new SaleMessagePayload(1, args));
			}
			if (type == MessageType.Sales) {
				handleSale(new SaleMessagePayload(args));
			}
			if (type == MessageType.Adjustment) {
				handleAdjustment(new AdjustmentMessagePayload(args));
				
			}	
		} catch (IllegalArgumentException iae) {
			System.out.println("Invalid Message format :"+ inMessage);
		}
	}

	private void handleSale(SaleMessagePayload saleMessagePayload) {
		if (ledger.ledgerSize() < 50) {
			ledger.addSale(saleMessagePayload);
			if (ledger.ledgerSize() == 10) {
				System.out.println(ProductTotalPrinter.printProductTotals(ledger));
			}
			if (ledger.ledgerSize() == 50) {
				System.out.println("Message reception pausing");
				System.out.println(AdjustmentsPrinter.printAdjustments(ledger));
			}
		}		
	}

	private void handleAdjustment(AdjustmentMessagePayload adjustmentMessagePayload) {
		ledger.adjustment(adjustmentMessagePayload);
	}
}
