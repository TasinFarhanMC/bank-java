/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Bank;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import net.tasinfarhan.bank.Bank.Accounts.Current_Account;
import java.io.File;

public record FileManager() {
    public static final String FileType = ".acc";

    public static final String AppData = computeAppData();
    private static String computeAppData() {
        String appdataEnv = System.getenv("APPDATA");
        if (appdataEnv != null && !appdataEnv.isEmpty()) {
            return appdataEnv + File.separator + ".bms-java";
        }
        return System.getProperty("user.home") + File.separator + ".bms-java";
    }

    public static final String Account = AppData + "/accounts/";

    public static void Write(Current_Account AccHolder) throws IOException {
        FileOutputStream Path2;
        File folder = new File(Account);
        if (!folder.exists()) {
            folder.mkdir();
        }
        try {
            Path2 = new FileOutputStream(Account + AccHolder.getAccountNo() + FileType);
        }
        catch (IOException e) {
            folder = new File(AppData);
            if (!folder.exists()) {
                folder.mkdir();
            }
            FileManager.Write(AccHolder);
            return;
        }
        ObjectOutputStream Write = new ObjectOutputStream(Path2);
        Write.writeObject(AccHolder);
        Write.close();
    }

    public static Current_Account Read(long AccHolder) throws Exception {
        FileInputStream Path2 = new FileInputStream(Account + AccHolder + FileType);
        ObjectInputStream Read = new ObjectInputStream(Path2);
        Current_Account deserializedCurrentAccount = (Current_Account)Read.readObject();
        Read.close();
        return deserializedCurrentAccount;
    }
}

