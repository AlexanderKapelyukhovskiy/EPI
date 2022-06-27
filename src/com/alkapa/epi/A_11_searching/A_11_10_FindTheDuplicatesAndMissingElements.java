package com.alkapa.epi.A_11_searching;

import java.util.ArrayList;
import java.util.List;

public class A_11_10_FindTheDuplicatesAndMissingElements {
    private static class DuplicatesAndMissing {
        Integer duplicate;
        Integer missing;

        public DuplicatesAndMissing(Integer duplicate, Integer missing) {
            this.duplicate = duplicate;
            this.missing = missing;
        }
    }

    public static DuplicatesAndMissing findDuplicateAndMissing(List<Integer> A) {
        int missXorDup = 0;
        for (int i = 0; i < A.size(); ++i) {
            missXorDup ^= i ^ A.get(i);
        }

        int differBit = missXorDup & (~(missXorDup - 1));
        int missOrDup = 0;
        for (int i = 0; i < A.size(); ++i) {
            if ((i & differBit) != 0) {
                missOrDup ^= i;
            }
            if ((A.get(i) & differBit) != 0) {
                missOrDup ^= A.get(i);
            }
        }
        return A.contains(missOrDup)
                ? new DuplicatesAndMissing(missOrDup, missOrDup ^ missXorDup)
                : new DuplicatesAndMissing(missOrDup ^ missXorDup, missOrDup);
    }

    public static void main (String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(1);
        A.add(3);
        A.add(4);
        A.add(4);
        A.add(5);

        DuplicatesAndMissing res = findDuplicateAndMissing(A);
        System.out.println(String.format("missing = %d, duplicate = %d", res.missing, res.duplicate));
    }
}
