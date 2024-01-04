package com.ken.aopdemo.dao;

import com.ken.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT.");
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT ACCOUNT.");
    }

    @Override
    public boolean doWork() {
        System.out.println("Did some work!");
        return false;
    }
}
