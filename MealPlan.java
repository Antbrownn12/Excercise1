package paymentsystem;

public class MealPlan extends PaymentMethod {

    private String lastStatus;

    public MealPlan(String accountHolder, double balance) {
        super(accountHolder, balance);
        this.lastStatus = "No transactions yet.";
    }

    @Override
    public void validateAccount() {
        if (balance < 0) {
            System.out.println("MealPlan INVALID: negative balance.");
            lastStatus = "Invalid.";
        } else {
            System.out.println("MealPlan valid.");
            lastStatus = "Valid.";
        }
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("[MealPlan] Attempting payment: $" + amount);

        if (amount > balance) {
            System.out.println("Transaction Declined.");
            lastStatus = "Declined: insufficient meal funds.";
        } else {
            balance -= amount;
            totalTransactions++;
            System.out.println("Transaction Approved.");
            lastStatus = "Approved: $" + amount + " deducted.";
        }
    }

    @Override
    public String getPaymentStatus() {
        return "[MealPlan] " + lastStatus;
    }
}
