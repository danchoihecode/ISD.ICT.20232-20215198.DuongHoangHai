package placeorder;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private Map<Product, Integer> products; // product and its corresponding quantity in cart

	private double subTotal;

	public Cart() {
		this.products = new HashMap<>();
		subTotal = 0;
	}

	public boolean checkProductAvailability() {
		for (Product p : products.keySet()) {
			if (p.getQuantity() < products.get(p))
				return false;
		}
		return true;
	}

	public void empty() {

	}

	public void addProduct(Product product, int quantity) {
		if (products.containsKey(product)) {
			products.put(product, products.get(product) + quantity);
		} else {
			products.put(product, quantity);
		}
		subTotal += product.getPrice() * quantity;
	}

	public Map<Product, Integer> getProducts() {
		return products;
	}

	public double getSubTotal() {

		return subTotal;
	}

}
