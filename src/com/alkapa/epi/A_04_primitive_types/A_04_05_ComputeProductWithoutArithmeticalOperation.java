package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.5 Compute product without arithmetical operators</h3>
 * <p>
 * Sometimes the processors used in ultra low power devices such as hearing aids do not have
 * dedicated hardware for performing multiplication. A program that needs to perform multiplication
 * must do so exactly using  lower-level primitives.
 * </p>
 * <p>
 * Write a program that multiplies two nonegative integers. The only operations you are allowed to
 * use are:
 * <ul>
 *     <li>assignment</li>
 *     <li>the bitwise operators >>, <<, |, &, ~, ^</li>
 *     <li>equality checks and Boolean combinations thereof</li>
 * </ul>
 * </p>
 * <p>
 * You may use loops and functions that you write yourself. The constraints imply, for example
 * that you cannot use increment or decrement, or test if y<x.
 * </p>
 */
public class A_04_05_ComputeProductWithoutArithmeticalOperation {
    /**
     * Produce multiplication without arithmetical operators (for ultra low power devices)
     *
     * @param x
     * @param y
     * @return product of x and y
     */
    public static long product(long x, long y) {
        long sum = 0;
        while (x != 0) {
            // Check if LBS of current X is 1
            boolean lbsOfXiOne = (x & 0x1) != 0;
            if (lbsOfXiOne) {
                // if LBS of X is 1 add sum and current y using add for ultra low power devices
                sum = bitwiseAdd(sum, y);
            }
            // shift x right for checking next bit
            x >>>= 1;
            // shift y left for next add operation
            y <<= 1;
        }
        return sum;
    }

    /**
     * Add x and y using bitwise operators (for ultra low power devices)
     *
     * @param x
     * @param y
     * @return addition of x and y
     */
    public static long bitwiseAdd(long x, long y) {
        return y == 0 ? x : bitwiseAdd(x ^ y, (x & y) << 1);
    }

    private static void test(long x, long y) {
        long prod = product(x, y);
        long expect = x * y;
        if (prod != expect) {
            System.out.print("Error!: ");
        }
        System.out.println(String.format("%d * %d = %d, should be %d", x, y, prod, expect));
    }

    public static void main(String[] args) {
        test(13, 9);
        test(10, 9);
        test(11, 21);
        test(28, 8);
        test(224, 82);
    }
}
