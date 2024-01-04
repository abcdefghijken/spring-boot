package com.ken.aopdemo.dao;

import com.ken.aopdemo.Account;

public interface AccountDAO {
    void addAccount();
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
}
