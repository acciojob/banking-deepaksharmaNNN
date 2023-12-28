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

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (digits <= 0 || sum < 0 || sum > digits * 9) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        Random random = new Random();
        int[] accountNumber = new int[digits];
        int currentSum = 0;

        // Generate random digits
        for (int i = 0; i < digits - 1; i++) {
            int digit = random.nextInt(10);
            accountNumber[i] = digit;
            currentSum += digit;
        }

        // The last digit is calculated to make the sum equal to the specified sum
        accountNumber[digits - 1] = sum - currentSum;

        // Check if the last digit is within the valid range (0-9)
        if (accountNumber[digits - 1] < 0 || accountNumber[digits - 1] > 9) {
            throw new Exception("Account Number can not be generated");
        }

        // Convert the array of digits to a string
        StringBuilder accountNumberString = new StringBuilder();
        for (int digit : accountNumber) {
            accountNumberString.append(digit);
        }

        return accountNumberString.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance = this.balance + amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(amount <= this.balance){
            this.balance = this.balance - amount;
        }else throw new Exception("Insufficient Balance");
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