package tech.messageproc.output;

import tech.messageproc.model.Sale;
import tech.messageproc.model.SalesLedger;
import tech.messageproc.model.operations.OperationType;

public class AdjustmentsPrinter {
	
	public static String printAdjustments(SalesLedger ledger) {
		StringBuilder builder = new StringBuilder();
		for (Sale sale : ledger.getAllSales()) {
			builder.append("Sale product:");
			builder.append(sale.getProductId());
			builder.append(" Quantity :");
			builder.append(sale.getQuantity());
			if (sale.getAllAdjustments() != null && sale.getAllAdjustments().size() > 0) {
				for (OperationType operation : sale.getAllAdjustments()) {
					builder.append(operation.toString());
					builder.append("\n");
				}				
			}
		}
		return builder.toString();
	}		
}
