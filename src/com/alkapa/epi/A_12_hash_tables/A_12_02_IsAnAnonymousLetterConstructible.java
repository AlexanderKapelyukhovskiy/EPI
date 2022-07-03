package com.alkapa.epi.A_12_hash_tables;

import java.util.HashMap;
import java.util.Map;

public class A_12_02_IsAnAnonymousLetterConstructible {
    public static boolean isAnAnonymousLetterConstructibleFromMagazine(String letterText, String magazineText) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < letterText.length(); ++i) {
            Integer n = map.get(letterText.charAt(i));
            map.put(letterText.charAt(i), n == null ? 1 : ++n);
        }

        for (int i = 0; i < magazineText.length() && map.size() > 0; ++i) {
            char key = magazineText.charAt(i);
            Integer n = map.get(key);
            if (n != null) {
                if (n == 1) {
                    map.remove(key);
                } else {
                    map.put(key, --n);
                }
            }
        }
        return map.size() == 0;
    }

    public static void test(String letterText, String magazineText) {
        System.out.println(
                String.format("%s - %s -> %b",
                        letterText, magazineText,
                        isAnAnonymousLetterConstructibleFromMagazine(letterText, magazineText)));
    }

    public static void main(String[] args) {
        test("I will find you", "I think I will find some body like you");
        test("I will find you", "I thought I would find some one like you");
        test("I will find you", "I thought I would find you");
    }
}
