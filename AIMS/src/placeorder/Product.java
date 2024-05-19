package placeorder;

public class Product {

	private String title;

	private int quantity; // quantity in the stock, not in the cart

	private int price;

	private double weight;

	private boolean rushOrderEligible;

	public Product(String title, int quantity, int price, double weight, boolean rushOrderEligible) {
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.weight = weight;
		this.rushOrderEligible = rushOrderEligible;
	}

	public boolean checkProductEligibility() {
		return rushOrderEligible;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getPrice() {
		return price;
	}

	public double getWeight() {
		return weight;
	}

}
