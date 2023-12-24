package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.8 Reverse digits</h3>
 * <p>
 * Write a program which takes an integer and returns this integer corresponding to the digits on the
 * input written in reverse order. For example the reverse of 42 is 24, and the reverse of -314 is -413.
 * </p>
 */
public class A_04_08_ReverseDigits {
    /**
     * Reverse digits in x
     *
     * @param x
     * @return reversed in x digits
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // get last digit in current x
            int newDigit = (x % 10);
            // get handled digits and shift them left
            int handledDigits = result * 10;
            // get new result
            result = handledDigits + newDigit;
            x /= 10;
        }
        return result;
    }

    private static void test(int x, int expected) {
        int res = reverse(x);
        if (x != expected) {
            System.out.print("Error! ");
        }
        System.out.println(String.format("reverse(%d) = %d, expected = %d", x, res, expected));
    }

    public static void main(String[] args) {
        test(123, 321);
        test(-123, -321);
        test(321, 123);
        test(888, 888);
        test(12345, 54321);
        test(0, 0);
    }
}
