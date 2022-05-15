package com.alkapa.epi.primitive_types;

public class A_04_08_ReverseDigits {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        return result;
    }

    public static void main (String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(321));
    }
}
