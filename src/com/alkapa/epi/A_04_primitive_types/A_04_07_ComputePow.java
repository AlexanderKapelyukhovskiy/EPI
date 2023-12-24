package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.7 Compute pow(x, y)</h3>
 * <p>
 * Write a program that takes a double x and an integer y and returns x^y. You can ignore overflow and
 * underflow.
 * </p>
 */
public class A_04_07_ComputePow {
    /**
     * Compute x power y
     *
     * @param x
     * @param y
     * @return pow(x, y)
     */
    public static double power(double x, int y) {
        double result = 1;
        long power = y;

        if (y < 0) {
            //if y is negative we should use 1/x to remove minus
            power *= -1;
            x = 1 / x;
        }

        while (power != 0) {
            if ((power & 0x1) != 0) {
                // if has LBS as 1 we need to multiply by x and remove it
                result *= x;
            }
            // get x in pow 2
            x *= x;
            // divide power by 2
            power >>>= 1;
        }
        return result;
    }

    public static void test(double x, int y) {
        double res = power(x, y);
        double expected = Math.pow(x, y);
        if (res != expected) {
            System.out.print("Error");
        }
        System.out.println(String.format("%f ^ %d = %f, expected: %f", x, y, res, expected));
    }

    public static void main(String[] args) {
        test(3, 3);
        test(8, 5);
        test(1.1, 11);
    }
}
