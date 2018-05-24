package tech.messageproc.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import tech.messageproc.model.payload.SaleMessagePayload;

public class SalesLedgerAddingSalesTest {
	
	@Test
	public void addSingleSaleToLedger() {
		SalesLedger ledger = new SalesLedger();
		SaleMessagePayload sale = new SaleMessagePayload("productA", 1);
		
		ledger.addSale(sale);
		
		assertTrue("Ledger not initalised", ledger != null);
		assertTrue("Ledger empty", ledger.ledgerSize() == 1);
		assertTrue("Product list not initalised", ledger.getProductList() != null);
		assertTrue("Product list empty", ledger.getProductList().size() == 1);
		assertFalse("Product list unexpected productId", ledger.getProductList().isNewProduct(sale.getProductId()));		
	}
	
	@Test
	public void addMultiSaleSingleProductToLedger() {
		SalesLedger ledger = new SalesLedger();
		SaleMessagePayload sale1 = new SaleMessagePayload("productA", 1);
		SaleMessagePayload sale2 = new SaleMessagePayload("productA", 2);
		
		ledger.addSale(sale1);
		ledger.addSale(sale2);
		
		assertTrue("Ledger not initalised", ledger != null);
		assertTrue("Ledger empty", ledger.ledgerSize() == 2);
		assertTrue("Product list not initalised", ledger.getProductList() != null);
		assertTrue("Product list empty", ledger.getProductList().size() == 1);
		assertFalse("Product list unexpected productId", ledger.getProductList().isNewProduct(sale1.getProductId()));		
	}

	@Test
	public void addMultiSalemMultiProductToLedger() {
		SalesLedger ledger = new SalesLedger();
		SaleMessagePayload sale1 = new SaleMessagePayload("productA", 1);
		SaleMessagePayload sale2 = new SaleMessagePayload("productA", 2);
		SaleMessagePayload sale3 = new SaleMessagePayload("productB", 2);
		
		ledger.addSale(sale1);
		ledger.addSale(sale2);
		ledger.addSale(sale3);
		
		assertTrue("Ledger not initalised", ledger != null);
		assertTrue("Ledger empty", ledger.ledgerSize() == 3);
		assertTrue("Product list not initalised", ledger.getProductList() != null);
		assertTrue("Product list empty", ledger.getProductList().size() == 2);
		assertFalse("Product list unexpected productId", ledger.getProductList().isNewProduct(sale1.getProductId()));		
	}

}
