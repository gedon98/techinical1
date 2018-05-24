package tech.messageproc.output;

import tech.messageproc.model.Product;
import tech.messageproc.model.SalesLedger;

public class ProductTotalPrinter {
	
	public static String printProductTotals(SalesLedger ledger) {
		StringBuilder builder = new StringBuilder();
		for (Product product : ledger.getProductList().allProducts()) {
			builder.append("Product :");
			builder.append(product.getName());
			builder.append("Total :");
			builder.append(ledger.getSalesTotalByProduct(product.getName()));
		}		
		return builder.toString();
	}
}
