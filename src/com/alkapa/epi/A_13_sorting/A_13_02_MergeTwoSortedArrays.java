package com.alkapa.epi.A_13_sorting;

import java.util.ArrayList;
import java.util.List;

public class A_13_02_MergeTwoSortedArrays {
    public static List<Integer> mergeTwoSortedArrays(List<Integer> A, int m, List<Integer> B, int n) {
        int a = m - 1, b = n - 1, writeIndex = m + n - 1;

        while (a >= 0 && b >=0) {
            if (A.get(a) > B.get(b)) {
                A.set(writeIndex--, A.get(a--));
            } else {
                A.set(writeIndex--, B.get(b--));
            }
        }

        while(b >= 0) {
            A.set(writeIndex--, B.get(b--));
        }

        return A;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(13);
        A.add(17);
        A.add(null);
        A.add(null);
        A.add(null);
        A.add(null);
        A.add(null);

        List<Integer> B = new ArrayList<>();
        B.add(3);
        B.add(7);
        B.add(11);
        B.add(19);

        List<Integer> res = mergeTwoSortedArrays(A, 3, B, 4);
        for (Integer r : res) {
            System.out.println(r);
        }
    }
}
