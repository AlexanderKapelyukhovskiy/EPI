package com.alkapa.epi.A_13_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_13_05_SmallestNonconstructibleValue {
    public static int smallestNonconstructibleValue(List<Integer> A) {
        Collections.sort(A);
        int sum = A.get(0);
        for (int i = 1; i < A.size(); ++i) {
            if (sum + 1 < A.get(i)) {
                return sum + 1;
            }
            sum += A.get(i);
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(5);
        A.add(10);
        A.add(25);
        System.out.println(smallestNonconstructibleValue(A));

        A = new ArrayList<>();
        A.add(12);
        A.add(2);
        A.add(1);
        A.add(15);
        A.add(2);
        A.add(4);
        System.out.println(smallestNonconstructibleValue(A));
    }
}
