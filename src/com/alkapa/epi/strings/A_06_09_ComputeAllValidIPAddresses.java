package com.alkapa.epi.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_06_09_ComputeAllValidIPAddresses {
    public static List<String> getValidIpAddresses(String s) {
        if (s == null || s.length() < 7) {
            return Collections.emptyList();
        }

        List<String> validIps = new ArrayList<>();

        for (int i = 1; i < 4; ++i) {
            String s1 = s.substring(0, i);
            if (!isValidAddressPart(s1)) {
                continue;
            }
            for (int j = 1; j < 4 && i + j < s.length(); ++j) {
                String s2 = s.substring(i, i + j);
                if (!isValidAddressPart(s2)) {
                    continue;
                }
                for (int k = 1; k < 4 && i + j + k < s.length(); ++k) {
                    String s3 = s.substring(i + j, i + j + k);
                    String s4 = s.substring(i + j + k);

                    if (!isValidAddressPart(s3) || !isValidAddressPart(s4)) {
                        continue;
                    }

                    validIps.add(String.format("%s.%s.%s.%s", s1, s2, s3, s4));
                }
            }
        }
        return validIps;
    }

    public static boolean isValidAddressPart(String s) {
        if (s == null || s.length() < 1 || s.length() > 3) {
            return false;
        }

        if (s.startsWith("0") && s.length() > 1) {
            return false;
        }

        int v = Integer.parseInt(s);
        if (v < 0 || v > 255) {
            return false;
        }

        return true;
    }

    public static void test(String s) {
        System.out.println(s + "->");
        List<String> validIps = getValidIpAddresses(s);
        for (String ip : validIps) {
            System.out.println(ip);
        }
    }

    public static void main(String[] args) {
        test("192168010");
    }
}
