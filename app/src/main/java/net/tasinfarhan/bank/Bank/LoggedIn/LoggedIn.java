/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Bank.LoggedIn;

import java.nio.file.Files;
import java.nio.file.Path;
import net.tasinfarhan.bank.Bank.FileManager;
import net.tasinfarhan.bank.Bank.Hub;
import net.tasinfarhan.bank.Bank.LoggedIn.Bio;
import net.tasinfarhan.bank.Util.Methods;

public record LoggedIn() {
    public static void LoggedInFun() throws Exception {
        while (true) {
            String Do;
            block11 : switch (Do = LoggedIn.printLDILabel()) {
                case "a": {
                    int Do2 = LoggedIn.Deposit();
                    switch (Do2) {
                        case -1: {
                            break block11;
                        }
                        case -2: {
                            Hub.HubFun();
                            return;
                        }
                        case -3: {
                            return;
                        }
                    }
                    break;
                }
                case "b": {
                    int Do2 = LoggedIn.Withdraw();
                    switch (Do2) {
                        case -1: {
                            break block11;
                        }
                        case -2: {
                            Hub.HubFun();
                            return;
                        }
                        case -3: {
                            return;
                        }
                    }
                    break;
                }
                case "c": {
                    LoggedIn.CheckBalance();
                    break;
                }
                case "d": 
                case "/h": {
                    Hub.HubFun();
                    return;
                }
                case "e": {
                    String Do2;
                    switch (Do2 = Bio.BioFun()) {
                        case "/b": 
                        case "/Err": {
                            LoggedIn.LoggedInFun();
                            return;
                        }
                        case "/c": {
                            return;
                        }
                        case "/h": {
                            Hub.HubFun();
                            return;
                        }
                    }
                    break;
                }
                case "f": {
                    LoggedIn.DeleteAccount(Hub.AccHolder.getAccountNo());
                    Hub.HubFun();
                    return;
                }
                case "/b": {
                    break;
                }
                case "/c": {
                    return;
                }
            }
        }
    }

    private static String printLDILabel() {
        Methods.println(Methods.Dash);
        Methods.println("\u001b[34m[TF Bank] \u001b[0mHow can I help you sir?");
        Methods.println("\u001b[33ma)\u001b[0mDeposit");
        Methods.println("\u001b[33mb)\u001b[0mWithdraw");
        Methods.println("\u001b[33mc)\u001b[0mCheck Balance");
        Methods.println("\u001b[33md)\u001b[0mLog-out");
        Methods.println("\u001b[33me)\u001b[0mBio");
        Methods.println("\u001b[33mf)\u001b[0mDelete Account");
        return Methods.InputNext().toLowerCase();
    }

    private static int Deposit() throws Exception {
        Methods.print("\u001b[34m[TF Bank] \u001b[0m\u001b[32mAmount: \u001b[0m");
        long amount = Methods.InputNextLong();
        if (amount < Hub.AccHolder.MinimalDepositAmount() && amount > 0L) {
            Methods.println("Minimal Deposit amount is " + Hub.AccHolder.MinimalDepositAmount());
            return LoggedIn.Deposit();
        }
        if (amount < -3L) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0mPlease enter a valid amount");
            return LoggedIn.Deposit();
        }
        switch ((int)amount) {
            case -1: {
                return -1;
            }
            case -2: {
                return -2;
            }
            case -3: {
                return -3;
            }
        }
        Hub.AccHolder.Deposit(amount, Hub.AccHolder);
        Hub.AccHolder.checkAccountBalance();
        return 0;
    }

    private static int Withdraw() throws Exception {
        Methods.print("\u001b[34m[TF Bank] \u001b[0m\u001b[32mAmount: \u001b[0m");
        long amount = Methods.InputNextLong();
        if (Hub.AccHolder.getAccountBalance() - amount < 0L) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0mInsufficient Balance (Balance: " + Hub.AccHolder.getAccountBalance() + ")");
            return LoggedIn.Withdraw();
        }
        if (amount > Hub.AccHolder.MaximumWithdrawAmount()) {
            Methods.println("Maximum Withdraw amount is " + Hub.AccHolder.MaximumWithdrawAmount());
            return LoggedIn.Withdraw();
        }
        if (amount < -3L) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0mPlease enter a valid amount");
            return LoggedIn.Withdraw();
        }
        switch ((int)amount) {
            case -1: {
                return -1;
            }
            case -2: {
                return -2;
            }
            case -3: {
                return -3;
            }
        }
        Hub.AccHolder.WithDraw(amount, Hub.AccHolder);
        Methods.println("Balance: " + Hub.AccHolder.getAccountBalance());
        return 0;
    }

    private static void CheckBalance() {
        Methods.println("\u001b[36mBalance: \u001b[0m" + Hub.AccHolder.getAccountBalance());
    }

    public static void DeleteAccount(long accNo) {
        try {
            Path path = Path.of(FileManager.Account + accNo + ".acc", new String[0]);
            Files.delete(path);
            Methods.println(Methods.Dash);
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[36mYou have deleted your account\u001b[0m");
        }
        catch (Exception e) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mUnable to find your Account\u001b[0m");
        }
    }
}

