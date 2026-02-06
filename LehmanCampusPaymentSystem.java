package paymentsystem;

import java.util.ArrayList;

public class LehmanCampusPaymentSystem {

    public static void main(String[] args) {

        ArrayList<Payable> paymentQueue = new ArrayList<>();

        CreditCard cc = new CreditCard("Antoine Brown", 100.0, 200.0);
        MealPlan mp = new MealPlan("Campus Student", 75.0);

        paymentQueue.add(cc);
        paymentQueue.add(mp);

        System.out.println("=== VALIDATING ACCOUNTS ===");
        cc.validateAccount();
        mp.validateAccount();

        System.out.println("\n=== PROCESSING PAYMENTS ===");
        for (Payable p : paymentQueue) {
            p.processPayment(50.0);
            System.out.println(p.getPaymentStatus());
        }

        System.out.println("\n=== FINAL SUMMARY ===");
        System.out.println("Total Transactions: " + PaymentMethod.totalTransactions);
    }
}
