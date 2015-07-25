package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by Yerusha on 2015-07-24.
 */
public class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int deposit(int amount) {
        this.balance += amount;
        return this.balance;
    }

    public int withdraw(int amount) {
        this.balance -= amount;
        return this.balance;
    }
}
