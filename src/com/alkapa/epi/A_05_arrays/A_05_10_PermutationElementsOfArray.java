package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_05_10_PermutationElementsOfArray {
    public static void applyPermutation(List<Integer> perms, List<Integer> A) {
        for(int i = 0; i < perms.size(); ++i) {
            while (perms.get(i) != i) {
                Collections.swap(A, i, perms.get(i));
                Collections.swap(perms, i, perms.get(i));
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> perms = new ArrayList<>();
        perms.add(2);
        perms.add(0);
        perms.add(1);
        perms.add(3);

        List<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(3);

        applyPermutation(perms, A);
        for (Integer i : A) {
            System.out.println(i);
        }

    }
}
