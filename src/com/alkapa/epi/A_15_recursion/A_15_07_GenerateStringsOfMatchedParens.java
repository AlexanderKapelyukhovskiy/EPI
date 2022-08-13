package com.alkapa.epi.A_15_recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_15_07_GenerateStringsOfMatchedParens {
    public static List<String> generateBalancedParentheses(int n) {
        Set<String> results = new HashSet<>();
        results.add("()");
        return generate(n, 1, results).stream().toList();
    }

    private static Set<String> generate(int n, int k, Set<String> candidates) {
        if (k == n) {
            return candidates;
        }
        Set<String> set = new HashSet<>();
        for (String s : candidates) {
            set.add("()" + s);
            set.add("(" + s + ")");
            set.add(s + "()");
        }
        return generate(n, k + 1, set);
    }

    public static List<String> generateBalancedParenthesesV2(int n) {
        List<String> result = new ArrayList<>();
        directGenerateBalancedParentheses(n, n, "", result);
        return result;
    }

    private static void directGenerateBalancedParentheses(int numLeftParensNeeded, int numRightParensNeeded, String validPrefix, List<String> result) {
        if(numRightParensNeeded == 0) {
            result.add(validPrefix);
            return;
        }

        if (numLeftParensNeeded > 0) {
            directGenerateBalancedParentheses(numLeftParensNeeded - 1, numRightParensNeeded, validPrefix + "(", result);
        }

        if (numLeftParensNeeded < numRightParensNeeded) {
            directGenerateBalancedParentheses(numLeftParensNeeded, numRightParensNeeded - 1, validPrefix + ")", result);
        }
    }

    public static void main (String[] args) {
        List<String> result = generateBalancedParenthesesV2(4);
        for (String s : result) {
            System.out.println(s);
        }
    }
}