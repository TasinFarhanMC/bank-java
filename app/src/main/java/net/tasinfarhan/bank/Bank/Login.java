/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Bank;

import net.tasinfarhan.bank.Bank.CreateAccount;
import net.tasinfarhan.bank.Bank.FileManager;
import net.tasinfarhan.bank.Bank.Hub;
import net.tasinfarhan.bank.Bank.LoggedIn.LoggedIn;
import net.tasinfarhan.bank.Util.Methods;

public record Login() {
    public static void LoginFun() throws Exception {
        String accPass;
        Methods.println("\u001b[34m[TF Bank] \u001b[0mPlease enter your");
        long AccNo = Login.InputAccNo();
        if (AccNo == -1L || AccNo == -2L) {
            Hub.HubFun();
            return;
        }
        if (AccNo == -3L) {
            return;
        }
        try {
            FileManager.Read(AccNo);
        }
        catch (Exception e) {
            String X;
            switch (X = Login.AccDoesNotExit()) {
                case "y": {
                    Login.CreateNewAcc();
                    return;
                }
                case "n": {
                    Login.Restart();
                    return;
                }
            }
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mError Restarting\u001b[0m");
            Login.LoginFun();
            return;
        }
        switch (accPass = Login.InputAccPass(AccNo)) {
            case "/h": {
                Hub.HubFun();
                return;
            }
            case "/c": {
                return;
            }
        }
        Hub.AccHolder = FileManager.Read(AccNo);
        Methods.println(Methods.Dash);
        Methods.println("\u001b[34m[TF Bank] \u001b[0mSuccessfully Logged-in");
        LoggedIn.LoggedInFun();
    }

    private static long InputAccNo() {
        Methods.print("\u001b[32mAccount No: \u001b[0m");
        long accNo = Methods.InputNextLong();
        String acc = String.valueOf(accNo);
        if (!(acc.length() >= 12 || acc.equals("-1") || acc.equals("-2") || acc.equals("-3"))) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mInvalid Account No\u001b[0m");
            return Login.InputAccNo();
        }
        switch (acc) {
            case "-1": {
                return -1L;
            }
            case "-2": {
                return -2L;
            }
            case "-3": {
                return -3L;
            }
        }
        return accNo;
    }

    private static String InputAccPass(long accNo) throws Exception {
        Methods.print("\u001b[32mAccount Password: \u001b[0m");
        String accPass = Methods.InputNextLine();
        if (Methods.ContainsDash(accPass)) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mInvalid Account Password\u001b[0m");
            return Login.InputAccPass(accNo);
        }
        if (!(accPass.equals(FileManager.Read(accNo).getAccPass()) || accPass.equals("/b") || accPass.equals("/c") || accPass.equals("/h"))) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mIncorrect Password\u001b[0m");
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[36mPlease try again\u001b[0m");
            return Login.InputAccPass(accNo);
        }
        switch (accPass) {
            case "/h": {
                return "/h";
            }
            case "/c": {
                return "/c";
            }
        }
        return accPass;
    }

    private static void CreateNewAcc() throws Exception {
        Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[36mRedirecting\u001b[0m");
        CreateAccount.CreateAccountFun();
    }

    private static String AccDoesNotExit() {
        Methods.println("\u001b[34m[TF Bank] \u001b[0mAccount does not exist!");
        Methods.println("\u001b[34m[TF Bank] \u001b[0mDo you want to create one?(Y/N)");
        return Methods.InputNext().toLowerCase();
    }

    private static void Restart() throws Exception {
        Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[36mRestarting\u001b[0m");
        Login.LoginFun();
    }
}

