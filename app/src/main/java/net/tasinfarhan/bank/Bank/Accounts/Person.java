/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Bank.Accounts;

import java.io.Serializable;

public abstract class Person
implements Serializable {
    public String name;
    public int age;

    public Person(String Name, int Age) {
        this.name = Name;
        this.age = Age;
    }
}

