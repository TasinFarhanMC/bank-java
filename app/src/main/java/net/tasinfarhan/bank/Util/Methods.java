/*
 * Decompiled with CFR 0.152.
 */
package net.tasinfarhan.bank.Util;

import java.util.Random;
import java.util.Scanner;

public record Methods() {
    private static final String Error = "\u001b[31mError Not a Number\u001b[0m";
    public static String Dash = " ";

    public static boolean ContainsDash(String string) {
        return string.contains(Dash);
    }

    public static boolean NotContainsDash(String string) {
        return !string.contains(Dash);
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void print(Object object) {
        System.out.print(object);
    }

    public static String InputNext() {
        Scanner Input = new Scanner(System.in);
        return Input.next();
    }

    public static String InputNextLine() {
        Scanner Input = new Scanner(System.in);
        return Input.nextLine();
    }

    public static int InputNextInt() {
        Scanner Input = new Scanner(System.in);
        try {
            return Input.nextInt();
        }
        catch (Exception e) {
            throw new RuntimeException(Error);
        }
    }

    public static long InputNextLong() {
        Scanner Input = new Scanner(System.in);
        try {
            return Input.nextLong();
        }
        catch (Exception e) {
            throw new RuntimeException(Error);
        }
    }

    public static float InputNextFloat() {
        Scanner Input = new Scanner(System.in);
        try {
            return Input.nextFloat();
        }
        catch (Exception e) {
            throw new RuntimeException(Error);
        }
    }

    public static double InputNextDouble() {
        Scanner Input = new Scanner(System.in);
        try {
            return Input.nextDouble();
        }
        catch (Exception e) {
            throw new RuntimeException(Error);
        }
    }

    public static int RandomInt(int Origin, int Bound) {
        Random random = new Random();
        return random.nextInt(Origin, Bound);
    }

    public static int RandomInt(boolean Origin, int Number) {
        Random random = new Random();
        if (Origin) {
            return random.nextInt(Number, Integer.MAX_VALUE);
        }
        return random.nextInt(Number);
    }

    public static int RandomInt() {
        Random random = new Random();
        return random.nextInt();
    }

    public static long RandomLong(long Origin, long Bound) {
        Random random = new Random();
        return random.nextLong(Origin, Bound);
    }

    public static long RandomLong(boolean Origin, long Number) {
        Random random = new Random();
        if (Origin) {
            return random.nextLong(Number, Long.MAX_VALUE);
        }
        return random.nextLong(Number);
    }

    public static long RandomLong() {
        Random random = new Random();
        return random.nextLong();
    }

    public static float RandomFloat(float Origin, float Bound) {
        Random random = new Random();
        return random.nextFloat(Origin, Bound);
    }

    public static float RandomFloat(boolean Origin, float Number) {
        Random random = new Random();
        if (Origin) {
            return random.nextFloat(Number, Float.MAX_VALUE);
        }
        return random.nextFloat(Number);
    }

    public static float RandomFloat() {
        Random random = new Random();
        return random.nextFloat();
    }

    public static double RandomDouble(double Origin, double Bound) {
        Random random = new Random();
        return random.nextDouble(Origin, Bound);
    }

    public static double RandomDouble(boolean Origin, double Number) {
        Random random = new Random();
        if (Origin) {
            return random.nextDouble(Number, Double.MAX_VALUE);
        }
        return random.nextDouble(Number);
    }

    public static double RandomDouble() {
        Random random = new Random();
        return random.nextDouble();
    }
}

