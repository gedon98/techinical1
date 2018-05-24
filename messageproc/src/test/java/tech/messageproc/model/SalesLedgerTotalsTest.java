package tech.messageproc.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tech.messageproc.model.payload.SaleMessagePayload;

public class SalesLedgerTotalsTest {
	
	@Test
	public void addSingleSaleToLedgerReportTotal() {
		SalesLedger ledger = new SalesLedger();
		SaleMessagePayload sale = new SaleMessagePayload("productA", 1, 0.1);
		
		ledger.addSale(sale);
		
		assertTrue("Ledger not initalised", ledger != null);
		assertTrue("Ledger empty", ledger.ledgerSize() == 1);
		assertTrue("Product list not initalised", ledger.getProductList() != null);
		assertTrue("Product list empty", ledger.getProductList().size() == 1);
		assertFalse("Product list unexpected productId", ledger.getProductList().isNewProduct(sale.getProductId()));		
		
		assertTrue("Zero Sale value", ledger.getSalesTotalByProduct(sale.getProductId()) == 0.1);
	}
	
	@Test
	public void addMultiSaleToLedgerReportTotal() {
		SalesLedger ledger = new SalesLedger();
		SaleMessagePayload sale = new SaleMessagePayload("productA", 1, 0.1);
		SaleMessagePayload sale2 = new SaleMessagePayload("productA", 10, 0.1);
		
		ledger.addSale(sale);
		ledger.addSale(sale2);
		
		assertFalse("Product list unexpected productId", ledger.getProductList().isNewProduct(sale.getProductId()));		
		
		assertTrue("Zero Sale value", ledger.getSalesTotalByProduct(sale.getProductId()) == 1.1);
	}
	
	@Test
	public void addMultiProductMultiSaleToLedgerReportTotal() {
		SalesLedger ledger = new SalesLedger();
		SaleMessagePayload sale = new SaleMessagePayload("productA", 1, 0.1);
		SaleMessagePayload sale2 = new SaleMessagePayload("productB", 100, 0.1);
		SaleMessagePayload sale3 = new SaleMessagePayload("productA", 10, 0.1);
		
		
		ledger.addSale(sale);
		ledger.addSale(sale2);
		ledger.addSale(sale3);
		
		assertFalse("Product list unexpected productId", ledger.getProductList().isNewProduct(sale.getProductId()));		
		
		assertTrue("Zero Sale value", ledger.getSalesTotalByProduct(sale.getProductId()) == 1.1);
	}

}
