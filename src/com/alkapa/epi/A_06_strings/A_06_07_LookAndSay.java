package com.alkapa.epi.A_06_strings;

public class A_06_07_LookAndSay {
    public static String lookAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; ++i) {
            s = nextNumber(s);
        }
        return s;
    }

    public static String nextNumber(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                ++i;
                ++count;
            }
            res.append(count).append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(lookAndSay(5));
    }
}
