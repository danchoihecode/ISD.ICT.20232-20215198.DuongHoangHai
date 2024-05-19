package placeorder;

import exception.PaymentException;

public class Client {

	private IPayment payment;

	public void updateTransactionOnFailure(PaymentException exception) {

	}

	public void updateTransactionOnSuccess(TransactionInfo trans) {

	}

}
