package com.driver;
import java.util.*;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        if (digits > 0 && sum >= 0 && sum <= digits * 9) {
            Random random = new Random();
            int[] accountNumber = new int[digits];
            int currentSum = 0;

            // Generate random digits
            for (int i = 0; i < digits - 1; ++i) {
                int digit = random.nextInt(10);
                accountNumber[i] = digit;
                currentSum += digit;
            }

            // Calculate the last digit to ensure the correct sum
            accountNumber[digits - 1] = sum - currentSum;

            // Validate the last digit
            if (accountNumber[digits - 1] >= 0 && accountNumber[digits - 1] <= 9) {
                StringBuilder accountNumberString = new StringBuilder();
                for (int digit : accountNumber) {
                    accountNumberString.append(digit);
                }

                return accountNumberString.toString();
            } else {
                throw new Exception("Account Number can not be generated");
            }
        } else {
            throw new IllegalArgumentException("Invalid input parameters");
        }
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance = this.balance + amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            throw new Exception("Insufficient Balance");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public double getMinBalance() {
        return minBalance;
    }
}