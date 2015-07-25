package com.thoughtworks.tddintro.accountbalance;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    private final Account account = new Account(100);

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        assertThat(new Account(100).deposit(50), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        assertThat(new Account(100).withdraw(50), is(50));
    }

//    @Test
//    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
//
//    }
}
