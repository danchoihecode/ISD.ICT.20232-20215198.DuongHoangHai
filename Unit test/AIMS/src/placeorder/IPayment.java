package placeorder;

public interface IPayment {

	public abstract void payOrder(double amount, String orderInfo, Client client);

}
