package com.alkapa.epi.A_15_recursion;

import java.util.ArrayList;
import java.util.List;

public class A_15_08_GeneratePalindromicDecomposition {
    public static List<List<String>> palindromicDecompositions(String text) {
        List<List<String>> result = new ArrayList<>();
        directPalindromicDecomposition(text, 0, new ArrayList<>(), result);
        return result;
    }

    private static void directPalindromicDecomposition(
            String text, int offset, List<String> partialPartition, List<List<String>> result) {
        if (offset == text.length()) {
            result.add(new ArrayList<>(partialPartition));
            return;
        }

        for (int i = offset + 1; i <= text.length(); ++i) {
            String prefix = text.substring(offset, i);
            if (isPalindrome(prefix)) {
                if (prefix.length() > 1){
                    partialPartition.add(prefix);
                }
                directPalindromicDecomposition(text, i, partialPartition, result);
                if (prefix.length() > 1) {
                    partialPartition.remove(partialPartition.size() - 1);
                }
            }
        }
    }

    private static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> results = palindromicDecompositions("0204451881");
        for (List<String> r : results) {
            for (String s : r) {
                System.out.print(s + ",");
            }
            System.out.println();
        }
    }
}
