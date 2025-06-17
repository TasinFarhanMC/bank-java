/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Bank.Accounts;

import net.tasinfarhan.bank.Bank.Accounts.Current_Account;

public class Savings_Account
extends Current_Account {
    public double loanTime1 = 0.0;
    public double loanTime2 = 0.0;
    public double loanTime3 = 0.0;
    public long loan1 = 0L;
    public long loan2 = 0L;
    public long loan3 = 0L;

    public Savings_Account(long AccountNo, String Name, int Age, String AccountPassword, long accountNo) {
        super(AccountNo, Name, Age, AccountPassword);
    }
}

