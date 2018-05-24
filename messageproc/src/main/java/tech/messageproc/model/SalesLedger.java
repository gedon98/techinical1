package tech.messageproc.model;

import java.util.ArrayList;
import java.util.List;

import tech.messageproc.model.operations.OperationType;
import tech.messageproc.model.payload.AdjustmentMessagePayload;
import tech.messageproc.model.payload.SaleMessagePayload;

public class SalesLedger {
	
	private ProductList products = new ProductList();
	private List<Sale> ledger = new ArrayList<Sale>();

	public SalesLedger() {}
	
	public void addSale(SaleMessagePayload newSale) {
		if (products.isNewProduct(newSale.getProductId())) {
			products.addProduct(new Product(newSale.getProductId(), newSale.getUnitPrice()));
		}			
		ledger.add(new Sale(newSale.getProductId(),newSale.getQuantity()));
	}
	
	public void adjustment(AdjustmentMessagePayload adjustment) {
		Product productToBeAdjusted = products.getProductByName(adjustment.getProductId());
		productToBeAdjusted.setPricePerUnit(adjustment.getOperation().performOperation(productToBeAdjusted.getPricePerUnit()));	
		addAdjustmentRecord( getSalesByProduct(adjustment.getProductId()), adjustment.getOperation());
	}
	
	private void addAdjustmentRecord(List<Sale> salesByProduct, OperationType operationType) {		
		for (Sale sale : salesByProduct) {
			sale.addAdjustment(operationType);
		}
	}

	public List<Sale> getSalesByProduct(String productName) {
		List<Sale> productSales = new ArrayList<Sale>();
		for (Sale sale : ledger) {
			if (sale.getProductId().equals(productName)) {
				productSales.add(sale);
			}
		}
		return productSales;
	}

	public int ledgerSize() {
		return ledger.size();
	}
	
	public ProductList getProductList() {
		return products;
	}
	
	public List<Sale> getAllSales() {
		return ledger;
	}
	
	public double getSalesTotalByProduct(String productId) {
		double productSales = 0.0;
		double productPrice = products.getProductPriceByName(productId);
		for (Sale sale : getSalesByProduct(productId)) {
 				productSales += sale.getQuantity() * productPrice;
		}
		return productSales;
	}
}
