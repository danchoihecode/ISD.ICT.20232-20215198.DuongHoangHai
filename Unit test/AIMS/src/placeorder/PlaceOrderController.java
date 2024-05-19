package placeorder;

public class PlaceOrderController {

	private PayOrderController payController;

	private PlaceRushOrderController rushController;

	private DeliveryForm deliveryForm;

	private CartScreen cartScreen;

	private Order order;

	private Cart cart;

	public void placeOrder(Cart cart) {
		this.cart = cart;
	}

	public void submitDeliveryInfo(String name, String phone, String email, String address, String province) {

	}

	public double calculateShippingFee(String province) {

		double heaviest = 0;
		for (Product p : cart.getProducts().keySet()) {
			double weight = p.getWeight() * cart.getProducts().get(p);
			if (weight > heaviest) {
				heaviest = weight;
			}
		}

		double fee = 0;
		if (province.equals("Hanoi") || province.equals("Ho Chi Minh City")) {

			if (heaviest <= 3.0) {
				fee = 22000;
			} else {

				double excessWeight = heaviest - 3.0;
				int additionalUnits = (int) Math.ceil(excessWeight / 0.5);
				fee = 22000 + additionalUnits * 2500;
			}
		} else {
			if (heaviest <= 0.5) {
				fee = 30000;
			} else {

				double excessWeight = heaviest - 0.5;
				int additionalUnits = (int) Math.ceil(excessWeight / 0.5);
				fee = 30000 + additionalUnits * 2500;
			}
		}

		double subTotal = cart.getSubTotal();
		if (subTotal > 100000) {
			fee = Math.max(0, fee - 25000);
		}

		return fee;
	}

	public void placeRushOrder() {

	}

	public void payOrder() {

	}

	public void sendEmail() {

	}

}
