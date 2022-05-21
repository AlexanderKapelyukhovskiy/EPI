package com.alkapa.epi.arrays;

import java.util.*;

public class A_05_15_ComputeRandomSubset {
    public static List<Integer> randomSubSet(int n, int k) {
        Map<Integer, Integer> changedElements = new HashMap<>();
        Random randIdxGen = new Random();

        for (int i = 0; i < k; ++i) {
            int randIdx = i + randIdxGen.nextInt(n - i);

            Integer ptr1 = changedElements.get(randIdx);
            Integer ptr2 = changedElements.get(i);

            if (ptr1 == null && ptr2 == null) {
                changedElements.put(i, randIdx);
                changedElements.put(randIdx, i);
            } else if (ptr1 == null && ptr2 != null) {
                changedElements.put(i, randIdx);
                changedElements.put(randIdx, ptr2);
            } else if (ptr1 != null && ptr2 == null) {
                changedElements.put(i, ptr1);
                changedElements.put(randIdx, i);
            } else {
                changedElements.put(i, ptr1);
                changedElements.put(randIdx, ptr2);
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; ++i) {
            result.add(changedElements.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : randomSubSet(100, 4)) {
            System.out.println(i);
        }
    }
}
