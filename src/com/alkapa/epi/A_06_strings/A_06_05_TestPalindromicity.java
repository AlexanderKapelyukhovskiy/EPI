package com.alkapa.epi.A_06_strings;

public class A_06_05_TestPalindromicity {
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isAlphabetic(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isAlphabetic(s.charAt(j))) {
                j++;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }

    public static void test(String s) {
        boolean isPalindrome = isPalindrome(s);
        System.out.println(String.format("%b - %s", isPalindrome, s));
    }

    public static void main(String[] args) {
        test("aba");
        test("abba");
        test("abbat");
    }
}
