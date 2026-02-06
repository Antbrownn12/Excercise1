package paymentsystem;

public class CreditCard extends PaymentMethod{
	private double creditLimit;
	private String lastStatus;
	
	public CreditCard(String accountHolder, double balance, double creditLimit) {
		super(accountHolder, balance);
		this.creditLimit = creditLimit;
        this.lastStatus = "No transactions yet.";
    }

    @Override
    public void validateAccount() {
        if (balance + creditLimit >= 0) {
            System.out.println("CreditCard account valid.");
        } else {
            System.out.println("CreditCard account INVALID.");
        }
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("[CreditCard] Attempting payment: $" + amount);

        double available = balance + creditLimit;

        if (amount > available) {
            System.out.println("Transaction Declined.");
            lastStatus = "Declined: insufficient credit.";
        } else {
            balance -= amount;
            totalTransactions++;
            System.out.println("Transaction Approved.");
            lastStatus = "Approved: $" + amount + " charged.";
        }
    }

    @Override
    public String getPaymentStatus() {
        return "[CreditCard] " + lastStatus;
    }

	}


