package com.alkapa.epi.A_15_recursion;

import java.util.ArrayList;
import java.util.List;

public class A_15_06_GenerateAllSubsetsOfSizeK {
    public static List<List<Integer>> generate(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        directedCombinations(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private static void directedCombinations(int n, int k, int offset, List<Integer> partialCombination,
                                             List<List<Integer>> result) {
        if (partialCombination.size() == k) {
            result.add(new ArrayList<>(partialCombination));
            return;
        }
        int numRemaining = k - partialCombination.size();
        for (int i = offset; i <= n && numRemaining <= n - i + 1; ++i) {
            partialCombination.add(i);
            directedCombinations(n, k, i + 1, partialCombination, result);
            partialCombination.remove(partialCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = generate(4, 2);
        for (List<Integer> r : res) {
            for (Integer i : r) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
