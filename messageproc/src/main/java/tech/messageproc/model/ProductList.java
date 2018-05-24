package tech.messageproc.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductList {
	Map<String, Product> products = new HashMap<String, Product>();
	
	public ProductList() {}
	
	public void addProduct(Product newProduct) {
		if (!products.containsKey(newProduct.getName())) {
			products.put(newProduct.getName(), newProduct);
		}		
	}
	
	public boolean isNewProduct(String productName) {
		return !products.containsKey(productName);
	}	
	
	public void productPriceAdjustment(Product newProductPrice) {
		if (products.containsKey(newProductPrice.getName())) {
			products.put(newProductPrice.getName(), newProductPrice);
		}
	}
	
	public double getProductPriceByName(String productName) {
		if (products.containsKey(productName)) {
			return getProductByName(productName).getPricePerUnit();
		}
		return 0.0;
	}
	
	public Product getProductByName(String name) {
		return products.get(name);
	}

	public int size() {
		return products.size();
	}

	public Collection<Product> allProducts() {		
		return products.values();
	}

}
