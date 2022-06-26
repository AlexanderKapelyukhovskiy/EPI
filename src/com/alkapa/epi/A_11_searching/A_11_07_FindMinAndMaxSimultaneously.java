package com.alkapa.epi.A_11_searching;

import java.util.ArrayList;
import java.util.List;

public class A_11_07_FindMinAndMaxSimultaneously {
    private static class MinMax {
        int min, max;
        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public static MinMax minMax(int a, int b) {
            return Integer.compare(a, b) > 0 ? new MinMax(b, a) : new MinMax(a, b);
        }
    }

    public static MinMax findMinMax(List<Integer> A) {
        MinMax minMax = MinMax.minMax(A.get(0), A.get(1));
        for (int i = 2; i < A.size(); ++i) {
            int a = A.get(i);
            if (minMax.min > a) {
                minMax.min = a;
            } else if (minMax.max < a) {
                minMax.max = a;
            }
        }
        return minMax;
    }

    public static MinMax findMinMaxV2(List<Integer> A) {
        MinMax globalMinMax = MinMax.minMax(A.get(0), A.get(1));

        for (int i = 2; i + 1 < A.size(); i += 2) {
            MinMax localMinMax = MinMax.minMax(A.get(i), A.get(i+1));
            globalMinMax = new MinMax(
                    Math.min(localMinMax.min, globalMinMax.min),
                    Math.max(localMinMax.max, globalMinMax.max));
        }

        if (A.size() % 2 != 0) {
            globalMinMax = new MinMax(
                    Math.min(A.get(A.size()-1), globalMinMax.min),
                    Math.max(A.get(A.size()-1), globalMinMax.max));
        }
        return globalMinMax;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(5);
        A.add(1);
        A.add(2);
        A.add(4);

        MinMax minMax = findMinMaxV2(A);
        System.out.println(String.format("min = %d, max = %d", minMax.min, minMax.max));
    }
}
