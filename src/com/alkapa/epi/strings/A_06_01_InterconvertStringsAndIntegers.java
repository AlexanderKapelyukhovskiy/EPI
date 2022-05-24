package com.alkapa.epi.strings;

public class A_06_01_InterconvertStringsAndIntegers {
    public static String toString(int x) {
        String sign = x < 0 ? "-" : "";

        x = Math.abs(x);

        if (x <= 9) {
            return sign + x;
        }

        StringBuilder sb = new StringBuilder(sign);

        int digits = (int) Math.log10(x);

        while (digits >= 0) {
            int divider = (int) Math.pow(10, digits);
            sb.append(x / divider);
            x %= divider;
            digits--;
        }

        return sb.toString();
    }

    public static int toInteger(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        boolean isNegative = s.charAt(0) == '-';
        if (isNegative) {
            if (s.length() == 1) {
                throw new IllegalArgumentException("s can't be just -");
            }
            s = s.substring(1);
        }

        int multiplier = (int) Math.pow(10, s.length() - 1);
        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            int d = (int) s.charAt(i) - 48;

            if (d < 0 || d > 9) {
                throw new IllegalArgumentException(s.charAt(i) + " is not allowed character");
            }

            result += multiplier * d;
            multiplier /= 10;
        }
        return isNegative ? -result : result;
    }

    public static String intToString(int x) {
        boolean isNegative = x < 0;

        x = Math.abs(x);

        StringBuilder sb = new StringBuilder();

        do {
            sb.append((char) ('0' + x % 10));
            x /= 10;
        } while (x != 0);

        if (isNegative) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }

    public static int stringToInteger(String s) {
        boolean isNegative = s.charAt(0) == '-';
        return (isNegative ? -1 : 1) *
                s.substring(isNegative ? 1 : 0).chars().reduce(0, (i, ch) -> i * 10 + ch - '0');
    }

    public static void testToInteger(String s) {
        System.out.println(String.format("%s -> %d", s, stringToInteger(s)));
    }

    public static void testToString(int x) {
        System.out.println(String.format("%d -> %s", x, intToString(x)));
    }

    public static void main(String[] args) {
        testToInteger("1");
        testToInteger("9");
        testToInteger("-1");
        testToInteger("-9");
        testToInteger("0");
        testToInteger("-0");

        testToInteger("123");
        testToInteger("-123");

        testToString(0);
        testToString(1);
        testToString(2);
        testToString(-9);
        testToString(-1211);
        testToString(12);
        testToString(123);
        testToString(1234);
    }
}
