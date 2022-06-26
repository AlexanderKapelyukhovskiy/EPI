package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class A_05_12_RandomSampling {
    public static void randomSampling(int k, List<Integer> A) {
        Random r = new Random();
        for (int i = 0; i < k; ++i) {
            Collections.swap(A, i, i + r.nextInt(A.size() - i));
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();

        A.add(3);
        A.add(7);
        A.add(5);
        A.add(11);

        randomSampling(3, A);

        for (Integer i : A) {
            System.out.println(i);
        }
    }
}
