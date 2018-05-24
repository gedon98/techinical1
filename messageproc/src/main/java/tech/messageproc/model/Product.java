package tech.messageproc.model;

public class Product {
	private String name;
	private double pricePerUnit;
	
	public Product(String name, double pricePerUnit) {
		this.name = name;
		this.pricePerUnit = pricePerUnit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
