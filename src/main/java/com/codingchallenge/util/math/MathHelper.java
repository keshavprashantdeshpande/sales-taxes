package com.codingchallenge.util.math;

import java.math.BigDecimal;

public class MathHelper {

    private static final double ROUND_OFF = 0.05;

    public static double roundOffValue(double amount) {
        return new BigDecimal(Math.ceil(amount * 20) / 20).doubleValue();
    }

    public static double truncate(double amount) {
        return new BigDecimal(amount).doubleValue();
    }
}
