package org.example.Utilities;

public class AccountNumberGenerator {

    public static String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder("AC1000");

        for (int i = 0; i < 5; i++) {
            int digit = (int) (Math.random() * 10);
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }

    public static String generatePaymentId() {
        StringBuilder accountNumber = new StringBuilder("LPP0");

        for (int i = 0; i < 5; i++) {
            int digit = (int) (Math.random() * 10);
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }


    public static String generateLoanId() {
        StringBuilder accountNumber = new StringBuilder("LOAN00");

        for (int i = 0; i < 5; i++) {
            int digit = (int) (Math.random() * 10);
            accountNumber.append(digit);
        }
        return accountNumber.toString();
    }
}
