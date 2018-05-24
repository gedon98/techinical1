package tech.messageproc.output;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tech.messageproc.model.SalesLedger;
import tech.messageproc.model.payload.SaleMessagePayload;

public class ProductTotalBuilderTest {
	
	@Test
	public void singleSaleTotalPrinter() {
		SalesLedger ledger = new SalesLedger();
		SaleMessagePayload sale = new SaleMessagePayload("productA", 1, 0.1);
		
		ledger.addSale(sale);
		ProductTotalPrinter printer = new ProductTotalPrinter();
		String output = printer.printProductTotals(ledger);
		
		assertTrue("null output produced", output != null);
		assertTrue("Empty output produced", output.length() > 0);
		assertTrue("Product header missing", output.contains("Product :"));
		assertTrue("Product total header missing", output.contains("Total :"));
		
		assertTrue("Product name not found", output.contains("productA"));
		assertTrue("Incorrect product total not found", output.contains("0.1"));
		
	}
	
	
	@Test
	public void multiSaleSingleProductTotalPrinter() {
		SalesLedger ledger = new SalesLedger();
		SaleMessagePayload sale1 = new SaleMessagePayload("productA", 1, 0.1);
		SaleMessagePayload sale2 = new SaleMessagePayload("productA", 10, 0.1);
		
		ledger.addSale(sale1);
		ledger.addSale(sale2);
		
		ProductTotalPrinter printer = new ProductTotalPrinter();
		String output = printer.printProductTotals(ledger);
		
		assertTrue("Product name not found", output.contains("productA"));
		assertTrue("Incorrect product total not found", output.contains("1.1"));
		
		assertTrue("Found more products than expected", output.split(":").length == 3);
	}
	
	@Test
	public void multiSaleMultiProductTotalPrinter() {
		SalesLedger ledger = new SalesLedger();
		SaleMessagePayload sale1 = new SaleMessagePayload("productA", 1, 0.1);
		SaleMessagePayload sale2 = new SaleMessagePayload("productB", 100, 0.1);
		SaleMessagePayload sale3 = new SaleMessagePayload("productA", 10, 0.1);
		
		ledger.addSale(sale1);
		ledger.addSale(sale2);
		ledger.addSale(sale3);
		
		ProductTotalPrinter printer = new ProductTotalPrinter();
		String output = printer.printProductTotals(ledger);
		
		assertTrue("Product name not found", output.contains("productA"));
		assertTrue("Incorrect product total not found", output.contains("1.1"));
		
		assertTrue("Found more products than expected", output.split(":").length == 5);
	}	
	
	

}
