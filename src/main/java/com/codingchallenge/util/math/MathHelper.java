package com.codingchallenge.util.math;

public class MathHelper {

    private static final double ROUND_OFF = 0.05;

    public static double roundOffValue(double amount) {
        return (int) (amount / ROUND_OFF + 0.5) * 0.05;
    }
}
