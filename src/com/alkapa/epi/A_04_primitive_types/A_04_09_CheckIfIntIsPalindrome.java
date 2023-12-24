package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.9 Check if a decimal integer is a palindrome</h3>
 * <p>
 * A palindromic string is one which reads the same forwards and backwards, e.g., "redivider". In This
 * problem, you are to write a program which determines if the decimal representation of integer is a
 * palindromic string. For example, your program should return true for the inputs 0, 1, 7, 11, 121, 333,
 * and 2147447421, and false fro the inputs -1, 12, 100, and 2147483647.
 * </p>
 * <p>
 * Write a program that takes an integer and determines if that integer's representation as a decimal
 * string is a palindromic.
 * </p>
 */
public class A_04_09_CheckIfIntIsPalindrome {
    /**
     * Checks if integer's representation as a decimal string is a palindromic
     *
     * @param x
     * @return true if x is palindromic
     */
    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            // negative number can't be palindromic
            return false;
        }

        // get num of digits
        final int numDigits = (int) (Math.floor(Math.log10(x))) + 1;
        // initial mask
        int msMask = (int) Math.pow(10, numDigits - 1); //
        for (int i = 0; i < numDigits / 2; i++) {
            if (x / msMask != x % 10) {
                return false;
            }
            x %= msMask; //remove the most significant digit of x
            x /= 10; //remove the least significant digit of x
            msMask /= 100;
        }
        return true;
    }

    private static void test(int x, boolean expected) {
        boolean res = isPalindromeNumber(x);
        if (res != expected) {
            System.out.print("Error! ");
        }
        System.out.println(String.format("%d is palindrome? %b, expected = %b", x, res, expected));
    }

    public static void main(String[] args) {
        test(-111, false);
        test(111, true);
        test(121, true);
        test(122, false);
        test(1234321, true);
        test(12341, false);
    }
}
