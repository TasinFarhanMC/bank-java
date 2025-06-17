/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Bank.LoggedIn;

import net.tasinfarhan.bank.Bank.Accounts.Current_Account;
import net.tasinfarhan.bank.Bank.FileManager;
import net.tasinfarhan.bank.Bank.Hub;
import net.tasinfarhan.bank.Util.Methods;

public record Bio() {
    public static String BioFun() throws Exception {
        Methods.println("\u001b[34m[TF Bank] \u001b[0mPlease enter your");
        Methods.print("\u001b[32mPassword: \u001b[0m");
        String pass = Methods.InputNext();
        if (!pass.equals(Hub.AccHolder.getAccPass())) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mIncorrect Password\u001b[0m");
            return Bio.BioFun();
        }
        block23: while (true) {
            switch (Bio.BioLabel()) {
                case "a": {
                    String Do = Bio.ChBio(Hub.AccHolder);
                    if (Do == null) continue block23;
                    switch (Do) {
                        case "/c": {
                            return "/c";
                        }
                        case "/h": {
                            Hub.HubFun();
                            return "/h";
                        }
                        case "/Err": {
                            Methods.println("Error!");
                            return "/Err";
                        }
                    }
                    break;
                }
                case "b": 
                case "/b": {
                    return "/b";
                }
                case "/c": {
                    return "/c";
                }
                case "/h": {
                    return "/h";
                }
                default: {
                    Methods.println("Error!");
                    return "/Err";
                }
            }
        }
    }

    private static String BioLabel() {
        Methods.println(Methods.Dash);
        Methods.println("\u001b[36mAccount No: \u001b[0m" + Hub.AccHolder.getAccountNo());
        Methods.println("\u001b[36mAccount Password: \u001b[0m" + Hub.AccHolder.getAccPass());
        Methods.println("\u001b[36mName: \u001b[0m" + Hub.AccHolder.name);
        Methods.println("\u001b[36mAge: \u001b[0m" + Hub.AccHolder.age);
        Methods.println(Methods.Dash);
        Methods.println("\u001b[33ma)\u001b[0mChange Bio");
        Methods.println("\u001b[33mb)\u001b[0mMain Menu");
        return Methods.InputNext().toLowerCase();
    }

    private static String ChBio(Current_Account AccHolder) throws Exception {
        block43: while (true) {
            block9 : switch (Bio.ChBioLabel()) {
                case "a": {
                    String Do = Bio.ChAccPass();
                    if (Do == null) continue block43;
                    switch (Do) {
                        case "/b": {
                            break block9;
                        }
                        case "/c": {
                            return "/c";
                        }
                        case "/h": {
                            return "/h";
                        }
                    }
                    break;
                }
                case "b": {
                    String Do = Bio.ChName();
                    if (Do == null) continue block43;
                    switch (Do) {
                        case "/b": {
                            break block9;
                        }
                        case "/c": {
                            return "/c";
                        }
                        case "/h": {
                            return "/h";
                        }
                    }
                    break;
                }
                case "c": {
                    int Do = Bio.ChAge();
                    switch (Do) {
                        case -1: {
                            break block9;
                        }
                        case -2: {
                            return "/h";
                        }
                        case -3: {
                            return "/c";
                        }
                    }
                    break;
                }
                case "d": {
                    FileManager.Write(AccHolder);
                    break block43;
                }
                case "/b": {
                    break block43;
                }
                case "/c": {
                    return "/c";
                }
                case "/h": {
                    return "/h";
                }
                default: {
                    return "/Err";
                }
            }
        }
        return null;
    }

    private static String ChBioLabel() {
        Methods.println(Methods.Dash);
        Methods.println("\u001b[34m[TF Bank] \u001b[0mWhat do you want to change sir?");
        Methods.println("\u001b[33ma)\u001b[0mAccount Password");
        Methods.println("\u001b[33mb)\u001b[0mName");
        Methods.println("\u001b[33mc)\u001b[0mAge");
        Methods.println("\u001b[33md)\u001b[0mFinish");
        return Methods.InputNext().toLowerCase();
    }

    private static String ChAccPass() {
        Methods.print("\u001b[34m[TF Bank] \u001b[0m\u001b[32mNew Account Password: \u001b[0m");
        String accPass = Methods.InputNext();
        if (accPass.contains(Methods.Dash)) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mInvalid Account Password\u001b[0m");
            return Bio.ChAccPass();
        }
        if (!(accPass.length() >= 8 || accPass.equals("/b") || accPass.equals("/c") || accPass.equals("/h"))) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mPassword can't be smaller than 8 digits\u001b[0m");
            return Bio.ChAccPass();
        }
        switch (accPass) {
            case "/b": {
                return "/b";
            }
            case "/c": {
                return "/c";
            }
            case "/h": {
                return "/h";
            }
        }
        Hub.AccHolder.setAccPass(accPass);
        return null;
    }

    private static String ChName() {
        Methods.print("\u001b[34m[TF Bank] \u001b[0m\u001b[32mNew Name: \u001b[0m");
        String newName = Methods.InputNextLine();
        if (!(newName.contains(Methods.Dash) || newName.equals("/b") || newName.equals("/c") || newName.equals("/h"))) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mPlease enter your full Name\u001b[0m");
            return Bio.ChName();
        }
        switch (newName) {
            case "/b": {
                return "/b";
            }
            case "/c": {
                return "/c";
            }
            case "/h": {
                return "/h";
            }
        }
        Hub.AccHolder.name = newName;
        return null;
    }

    private static int ChAge() {
        Methods.print("\u001b[34m[TF Bank] \u001b[0m\u001b[32mNew Age: \u001b[0m");
        int newAge = Methods.InputNextInt();
        if (newAge < -3 || newAge == 0) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mInvalid Age\u001b[0m");
            return Bio.ChAge();
        }
        if (newAge < 18 && newAge > 0) {
            Methods.println("\u001b[34m[TF Bank] \u001b[0m\u001b[31mAge can't be less than 18\u001b[0m");
            return Bio.ChAge();
        }
        switch (newAge) {
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
        Hub.AccHolder.age = newAge;
        return 0;
    }
}

