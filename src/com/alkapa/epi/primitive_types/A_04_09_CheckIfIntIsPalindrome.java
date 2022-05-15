package com.alkapa.epi.primitive_types;

public class A_04_09_CheckIfIntIsPalindrome {
    public static boolean isPalindromeNumber(int x) {
        if (x < 0) {
            return false;
        }

        final int numDigits = (int)(Math.floor(Math.log10(x))) + 1; // get num of digits
        int msMask = (int)Math.pow(10, numDigits -1); //
        for (int i = 0; i < numDigits / 2;i++ ){
            if (x / msMask != x % 10) {
                return false;
            }
            x %= msMask; //remove the most significant digit of x
            x /= 10; //remove the least significant digit of x
            msMask /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(111));
        System.out.println(isPalindromeNumber(121));
        System.out.println(isPalindromeNumber(122));
        System.out.println(isPalindromeNumber(1234321));
    }
}
