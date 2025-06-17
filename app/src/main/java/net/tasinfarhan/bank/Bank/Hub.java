/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Bank;

import java.io.File;
import net.tasinfarhan.bank.Bank.Accounts.Current_Account;
import net.tasinfarhan.bank.Bank.CreateAccount;
import net.tasinfarhan.bank.Bank.FileManager;
import net.tasinfarhan.bank.Bank.Login;
import net.tasinfarhan.bank.Util.Methods;

public record Hub() {
    public static final String BankName = "\u001b[34m[TF Bank] \u001b[0m";
    public static Current_Account AccHolder;

    public static void HubFun() throws Exception {
        String Do;
        switch (Do = Hub.printHubLabel()) {
            case "a": {
                CreateAccount.CreateAccountFun();
                break;
            }
            case "b": {
                Login.LoginFun();
                break;
            }
            case "c": {
                Hub.CommandsFun();
                Hub.HubFun();
                break;
            }
            case "d": 
            case "/c": {
                break;
            }
            case "/b": 
            case "/h": {
                Hub.HubFun();
                break;
            }
            default: {
                Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mError Restarting\u001b[0m");
                Hub.HubFun();
            }
        }
    }

    private static String printHubLabel() {
        Methods.println(Methods.Dash);
        Methods.println("\u001b[34m[TF Bank] \u001b[0mHow can I help you?");
        Methods.println("\u001b[33ma)\u001b[0mCreate an Account");
        Methods.println("\u001b[33mb)\u001b[0mLogin");
        Methods.println("\u001b[33mc)\u001b[0mCommands");
        Methods.println("\u001b[33md)\u001b[0mClose");
        return Methods.InputNext().toLowerCase();
    }

    private static void CommandsFun() {
        Methods.println(Methods.Dash);
        Methods.println("\u001b[36mFor Digits\u001b[0m");
        Methods.println("\u001b[35m/b\u001b[0m to go back (if possible)");
        Methods.println("\u001b[35m/h\u001b[0m to go back to main menu");
        Methods.println("\u001b[35m/c\u001b[0m to close (if possible)");
        Methods.println(Methods.Dash);
        Methods.println("\u001b[36mFor Numbers\u001b[0m");
        Methods.println("\u001b[35m-1\u001b[0m to go back (if possible)");
        Methods.println("\u001b[35m-2\u001b[0m to go back to main menu");
        Methods.println("\u001b[35m-3\u001b[0m to close (if possible)");
    }

    public static void Start() throws Exception {
        File folder = new File(FileManager.AppData);
        if (!folder.exists()) {
            folder.mkdir();
        }
        Methods.println(Methods.Dash);
        Methods.println("\u001b[34m[TF Bank] \u001b[0mWelcome to TF Bank an interest free bank");
        Hub.HubFun();
    }
}

