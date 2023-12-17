package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.6 Compute quotient without arithmetic operators</h3>
 * <p>
 * Given two positive integers, compute their quotient, using only the addition, subtraction, and
 * shifting operations.
 * </p>
 */
public class A_04_06_ComputeQuotientWithoutArithmeticalOperations {
    public static int divide(int x, int y) {
        int result = 0;
        int power = 32;
        long yPower = (long) x << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }
            result += 1 << power;
            x -= yPower;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(100, 90));
    }
}
