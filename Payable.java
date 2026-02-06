package paymentsystem;

public interface Payable {
	void processPayment(double amount);
	String getPaymentStatus();
	

}
