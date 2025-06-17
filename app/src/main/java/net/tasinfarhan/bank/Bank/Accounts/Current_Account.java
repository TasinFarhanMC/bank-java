/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Bank.Accounts;

import net.tasinfarhan.bank.Bank.Accounts.Person;
import net.tasinfarhan.bank.Bank.FileManager;
import net.tasinfarhan.bank.Bank.Hub;
import net.tasinfarhan.bank.Util.Methods;

public class Current_Account
extends Person {
    public final long accountNo;
    public String accountPassword;
    public long accountBalance;

    public Current_Account(long AccountNo, String Name, int Age, String AccountPassword) {
        super(Name, Age);
        this.accountNo = AccountNo;
        this.accountPassword = AccountPassword;
        this.accountBalance = 0L;
    }

    public String getAccPass() {
        return this.accountPassword;
    }

    public void setAccPass(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public long getAccountBalance() {
        return this.accountBalance;
    }

    public void checkAccountBalance() {
        Methods.println("\u001b[34m[TF Bank] \u001b[0mBalance: " + Hub.AccHolder.getAccountBalance());
    }

    public void Deposit(long DepositAmount, Current_Account AccHolder) throws Exception {
        this.accountBalance += DepositAmount;
        FileManager.Write(AccHolder);
    }

    public long MinimalDepositAmount() {
        if (this.accountBalance < 1000L) {
            return 250L;
        }
        return this.accountBalance / 4L;
    }

    public void WithDraw(long WithDrawAmount, Current_Account AccHolder) throws Exception {
        this.accountBalance -= WithDrawAmount;
        FileManager.Write(AccHolder);
    }

    public long MaximumWithdrawAmount() {
        if (this.accountBalance < 1000L) {
            return 1000L;
        }
        return this.accountBalance / 2L;
    }

    public long getAccountNo() {
        return this.accountNo;
    }
}

