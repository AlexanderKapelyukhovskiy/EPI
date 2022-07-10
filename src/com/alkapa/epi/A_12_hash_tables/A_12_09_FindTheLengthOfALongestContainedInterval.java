package com.alkapa.epi.A_12_hash_tables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class A_12_09_FindTheLengthOfALongestContainedInterval {
    public static int longestContainedRange(List<Integer> A) {
        HashSet<Integer> unprocessedSet = new HashSet<>(A);
        int longest = 0;
        while (!unprocessedSet.isEmpty()) {
            Integer a = unprocessedSet.iterator().next();
            unprocessedSet.remove(a);

            int lowerBound = a - 1;
            while (unprocessedSet.contains(lowerBound)){
                unprocessedSet.remove(lowerBound);
                lowerBound--;
            }

            int upperBound = a + 1;
            while (unprocessedSet.contains(upperBound)) {
                unprocessedSet.remove(upperBound);
                upperBound++;
            }
            longest = Math.max(longest, upperBound - lowerBound - 1);
        }
        return longest;
    }

    public static void main (String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(-2);
        A.add(7);
        A.add(9);
        A.add(8);
        A.add(1);
        A.add(2);
        A.add(0);
        A.add(-1);
        A.add(5);
        A.add(8);

        System.out.println(longestContainedRange(A));
    }
}
