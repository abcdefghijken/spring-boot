package com.ken.aopdemo.dao;

import com.ken.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount();
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
    public String getName();
    public void setName(String name);
    public String getServiceCode();
    public void setServiceCode(String serviceCode);
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
}
