package com.alkapa.epi.strings;

public class A_06_11_ImplementRunLengthEncoding {
    public static String rleEncode(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i <= s.length(); ++i) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(String.format("%d%s", count, s.charAt(i - 1)));
                count = 1;
            } else {
                count++;
            }
        }
        return sb.toString();
    }

    public static String rleDecodeV2(String s) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + s.charAt(i) - '0';
            } else {
                while (n > 0) {
                    sb.append(c);
                    n--;
                }
            }
        }
        return sb.toString();
    }

    public static void test(String s) {
        String encoded = rleEncode(s);
        String decoded = rleDecodeV2(encoded);

        System.out.println(String.format("%s -> %s -> %s", s, encoded, decoded));
    }

    public static void main(String[] args) {
        test("eeeffffccc");
        test("eefffffccccc");
        test("e");
        test("abcdefg");
    }
}
