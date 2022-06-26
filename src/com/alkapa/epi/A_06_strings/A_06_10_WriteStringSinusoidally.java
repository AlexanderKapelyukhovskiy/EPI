package com.alkapa.epi.A_06_strings;

public class A_06_10_WriteStringSinusoidally {
    public static String sinusoidally(String s) {
        if (s==null || s.length() == 1) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int i = 1;

        while (i < s.length()) {
            result.append(s.charAt(i));
            i += 4;
        }

        i = 0;

        while (i < s.length()) {
            result.append(s.charAt(i));
            i += 2;
        }

        i = 3;

        while (i < s.length()) {
            result.append(s.charAt(i));
            i += 4;
        }

        return result.toString();
    }

    public static void test (String s) {
        String sin = sinusoidally(s);
        System.out.println(String.format("%s -> %s", s, sin));
    }

    public static void main(String[] arg) {
        test("Hello_World!");
        test("I_Love_You_So_Much");
    }
}
