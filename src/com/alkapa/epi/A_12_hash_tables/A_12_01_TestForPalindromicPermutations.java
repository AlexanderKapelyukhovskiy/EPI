package com.alkapa.epi.A_12_hash_tables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class A_12_01_TestForPalindromicPermutations {
    public static boolean testForPalindromicPermutation(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); ++i) {
            map.putIfAbsent(word.charAt(i), 0);
            map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
        }
        boolean odd = false;
        for (Integer n : map.values()) {
            if (n % 2 != 0) {
                if (odd) {
                    return false;
                }
                odd = true;
            }
        }
        return true;
    }

    public static boolean canFormPalindrome(String s) {
        Set<Character> map = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            Character c = s.charAt(i);
            if (map.contains(c)) {
                map.remove(c);
            } else {
                map.add(c);
            }
        }

        return map.size() <= 1;
    }

    public static void test(String w) {
        //System.out.println(String.format("%s -> %s", w, testForPalindromicPermutation(w)));
        System.out.println(String.format("%s -> %s", w, canFormPalindrome(w)));
    }

    public static void main(String[] args) {
        test("level");
        test("rotator");
        test("edified");
        test("test");
    }
}

