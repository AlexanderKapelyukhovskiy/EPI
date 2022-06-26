package com.alkapa.epi.A_06_strings;

import java.util.Map;

public class A_06_08_ConvertFromRomanToDecimal {
    public static int romanToDecimal(String s) {
        Map<Character, Integer> T = Map.of(
                'I', 1, 'V', 5, 'X', 10,
                'L', 50, 'C', 100, 'D', 500,
                'M', 1000);

        int sum = T.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; --i) {
            int a = T.get(s.charAt(i));
            int b = T.get(s.charAt(i+1));

            if (a < b) {
                sum -= a;
            } else {
                sum += a;
            }
        }
        return sum;
    }

    public static void test (String s) {
        int v = romanToDecimal(s);
        System.out.println(String.format("%s -> %d", s, v));
    }

    public static void main(String[] args) {
        test("XVI");
        test("XIV");
    }
}
