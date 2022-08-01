package com.alkapa.epi.A_14_binary_search_trees;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class A_14_07_EnumerateExtendedIntegers {
    private static double sqrt2 = Math.sqrt(2);

    private static class Number {
        public int a,b;
        public double val;
        public Number(int a, int b) {
            this.a = a;
            this.b = b;
            this.val = a + b * sqrt2;
        }
    }

    public static List<Double> generateKABSqrt2(int k) {
        SortedSet<Number> candidates = new TreeSet<>((a,b) -> Double.compare(a.val, b.val));
        candidates.add(new Number(0 , 0));

        List<Double> results = new ArrayList<>();

        while(results.size() < k) {
            Number nextSmallest = candidates.first();
            results.add(nextSmallest.val);

            candidates.add(new Number(nextSmallest.a + 1, nextSmallest.b));
            candidates.add(new Number(nextSmallest.a, nextSmallest.b + 1));
            candidates.remove(nextSmallest);
        }
        return results;
    }

    public static List<Double> generateKABSqrt2WithNoBST(int k) {
        List<Number> candidates = new ArrayList<>();
        candidates.add(new Number(0, 0));

        int i = 0, j = 0;
        for(int n = i; n < k; ++n) {
            Number ci1 = new Number(candidates.get(i).a + 1, candidates.get(i).b);
            Number cj1 = new Number(candidates.get(j).a , candidates.get(j).b + 1);
            candidates.add( ci1.val < cj1.val ? ci1 : cj1);

            if (ci1.val == candidates.get(candidates.size() - 1).val) {
                i++;
            }

            if (cj1.val == candidates.get(candidates.size() - 1).val) {
                j++;
            }
        }
        return candidates.stream().map(c -> c.val).collect(Collectors.toList());
    }
}

