package tech.messageproc.model.payload;

public class SaleMessagePayload {
	private String productId;
	private int quantity;
	private double unitPrice;
	
	public SaleMessagePayload(String productId, int quantity) {
		this.productId = productId;
		this.quantity = quantity;				
	}
	
	public SaleMessagePayload(String productId, int quantity, double unitPrice) {
		this.productId = productId;
		this.quantity = quantity;	
		this.unitPrice = unitPrice;
	}

	public SaleMessagePayload(String[] args) throws IllegalArgumentException {
		productId = args[1];
		try {
			quantity = Integer.valueOf(args[2]);
			unitPrice = Double.valueOf(args[3]);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("Invalid Format for Message");
		}
	}

	public SaleMessagePayload(int i, String[] args) {
		productId = args[1];
		quantity = 1;
		try {
			unitPrice = Double.valueOf(args[3]);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException("Invalid Format for Message");
		}

	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotalValue() {
		return 0.0;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

}
