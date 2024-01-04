package com.ken.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING MEMBERSHIP ACCOUNT.");
    }

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING SILLY MEMBERSHIP ACCOUNT.");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println("Sleeping..");
    }
}
