package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_05_11_NextPermutation {
    public static List<Integer> nextPermutation(List<Integer> perm) {
        //find smallest not in order
        int inversionPoint = -1;
        for (int i = perm.size() - 1; i >= 1; --i) {
            if (perm.get(i - 1) < perm.get(i)) {
                inversionPoint = i - 1;
                break;
            }
        }
        if (inversionPoint == -1) {
            return Collections.emptyList();
        }

        //find inversionPoint for swap
        for (int i = perm.size() - 1; i > inversionPoint; --i) {
            if (perm.get(i) > perm.get(inversionPoint)) {
                Collections.swap(perm, inversionPoint, i);
                break;
            }
        }

        //reverse subarray
        Collections.reverse(perm.subList(inversionPoint + 1, perm.size()));
        return perm;
    }

    public static void main(String[] args) {
        List<Integer> perm = new ArrayList<>();
        perm.add(6);
        perm.add(2);
        perm.add(5);
        perm.add(4);
        perm.add(1);
        perm.add(0);

        List<Integer> result = nextPermutation(perm);
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
