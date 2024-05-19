package placeorder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Order {

	private Map<Product, Integer> products;

	private DeliveryInfo deliveryInfo;

	private int shippingFee;

	private TransactionInfo transactionInfo;

	public boolean checkRushOrderSupportability() {
		return false;
	}

	public void updateOrder(LocalDateTime deliveryTime, String deliveryInstructions) {

	}

	public Order(Cart cart, DeliveryInfo deliveryInfo, int shippingFee) {

	}

	public void saveTransactionInfo(TransactionInfo transactionInfo) {

	}

}
