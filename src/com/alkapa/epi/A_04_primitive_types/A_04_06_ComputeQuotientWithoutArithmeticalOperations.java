package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.6 Compute quotient without arithmetic operators</h3>
 * <p>
 * Given two positive integers, compute their quotient, using only the addition, subtraction, and
 * shifting operations.
 * </p>
 */
public class A_04_06_ComputeQuotientWithoutArithmeticalOperations {
    /**
     * devide without arithmetic operators
     *
     * @param x
     * @param y
     * @return quotient of x and y
     */
    public static int divide(int x, int y) {
        int result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            // searching for biggest 2^k * y which is smaller than x
            while (yPower > x) {
                // shift right 2^k * y for 1
                yPower >>>= 1;
                --power;
            }
            // when we found k ( x >= 2^k * y ) we add 2^k to res and decrease x for 2^k * y
            result += 1 << power;
            x -= yPower;
        }
        return result;
    }

    private static void test(int x, int y) {
        int d = divide(x, y);
        int expect = x / y;
        if (d != expect) {
            System.out.print("Error: ");
        }
        System.out.println(String.format("%d / %d = %d", x, y, d));
    }

    public static void main(String[] args) {
        test(11, 2);
        test(900, 90);
        test(100, 90);
    }
}
