package com.alkapa.epi.A_06_strings;

public class A_06_12_FindTheFirstOccurrenceOfSubstring {
    public static int rabinKarp(String t, String s) {
        if (t == null) {
            throw new IllegalArgumentException("t can't be null");
        }
        if (s == null) {
            throw new IllegalArgumentException("s can't be null");
        }

        if (s.length() > t.length()) {
            return  -1;
        }

        final int BASE = 26;
        int tHash = 0;
        int sHash = 0;
        int powerS = 1;

        for (int i = 0; i < s.length(); ++i) {
            powerS = i  > 0 ? BASE * powerS : 1;
            tHash = tHash * BASE + t.charAt(i);
            sHash = sHash * BASE + s.charAt(i);
        }

        for (int i = s.length(); i < t.length(); ++i) {
            if (tHash == sHash && t.substring(i - s.length(), i).equals(s)) {
                return i - s.length();
            }
            tHash -= t.charAt(i - s.length()) * powerS;
            tHash = tHash * BASE + t.charAt(i);
        }

        if (tHash == sHash && t.substring(t.length() - s.length()).equals(s)) {
            return t.length() - s.length();
        }

        return -1;
    }

    public static void test(String t, String s) {
        int pos = rabinKarp(t, s);
        System.out.println(String.format("%s %s %d", t, s , pos));
    }

    public static void main(String[] args) {
        test("gacgcca", "cgc");
        test("gacgcca", "cgcc");
        test("gacgaca", "cgcc");
    }
}

