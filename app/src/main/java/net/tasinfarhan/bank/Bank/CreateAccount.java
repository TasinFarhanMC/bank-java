/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Bank;

import net.tasinfarhan.bank.Bank.Accounts.Current_Account;
import net.tasinfarhan.bank.Bank.FileManager;
import net.tasinfarhan.bank.Bank.Hub;
import net.tasinfarhan.bank.Util.Methods;

public record CreateAccount() {
    private static int Age;
    private static String AccPass;

    public static void CreateAccountFun() throws Exception {
        long AccountNo = Methods.RandomLong(100000000000L, 1000000000000L);
        try {
            FileManager.Read(AccountNo);
            CreateAccount.CreateAccountFun();
        }
        catch (Exception e) {
            String Name;
            Methods.println(Methods.Dash);
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[36mAccount No: \u001b[0m" + AccountNo);
            Methods.println("\u001b[34m[TF Bank] \u001b[0mPlease enter your");
            switch (Name = CreateAccount.InputName()) {
                case "/h": {
                    Hub.HubFun();
                    return;
                }
                case "/c": {
                    return;
                }
            }
            Hub.AccHolder = new Current_Account(AccountNo, Name, Age, AccPass);
            FileManager.Write(Hub.AccHolder);
            Hub.HubFun();
        }
    }

    private static String InputName() {
        Methods.print("\u001b[32mName: \u001b[0m");
        String Name = Methods.InputNextLine();
        if (!(Name.contains(Methods.Dash) || Name.equals("/b") || Name.equals("/c") || Name.equals("/h"))) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mPlease enter your full Name\u001b[0m");
            return CreateAccount.InputName();
        }
        switch (Name) {
            case "/b": 
            case "/h": {
                return "/h";
            }
            case "/c": {
                return "/c";
            }
        }
        Age = CreateAccount.InputAge();
        switch (Age) {
            case -1: {
                return CreateAccount.InputName();
            }
            case -2: {
                return "/h";
            }
            case -3: {
                return "/c";
            }
        }
        return Name;
    }

    private static int InputAge() {
        Methods.print("\u001b[32mAge: \u001b[0m");
        int Age = Methods.InputNextInt();
        if (Age < -3 || Age == 0) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mInvalid Age\u001b[0m");
            return CreateAccount.InputAge();
        }
        if (Age < 18 && Age > 0) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mAge can't be less than 18\u001b[0m");
            return CreateAccount.InputAge();
        }
        switch (Age) {
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
        switch (AccPass = CreateAccount.InputAccPass()) {
            case "/b": {
                return CreateAccount.InputAge();
            }
            case "/h": {
                return -2;
            }
            case "/c": {
                return -3;
            }
        }
        return Age;
    }

    private static String InputAccPass() {
        Methods.print("\u001b[32mAccount Password: \u001b[0m");
        String accPass = Methods.InputNextLine();
        if (accPass.contains(Methods.Dash) && !accPass.equals("/b") && !accPass.equals("/c") && !accPass.equals("/h")) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mInvalid Account Password\u001b[0m");
            return CreateAccount.InputAccPass();
        }
        if (!(accPass.length() >= 8 || accPass.equals("/b") || accPass.equals("/h") || accPass.equals("/c"))) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mPassword can't be smaller than 8 digits\u001b[0m");
            return CreateAccount.InputAccPass();
        }
        switch (accPass) {
            case "/b": {
                return "/b";
            }
            case "/h": {
                return "/h";
            }
            case "/c": {
                return "/c";
            }
        }
        return accPass;
    }
}

