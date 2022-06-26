package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A_05_14_ComputeRandomPermutation {
    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> A = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            A.add(i);
        }

        Random r = new Random();
        List<Integer> result = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            int next = r.nextInt(i, n);
            result.add(A.get(next));
            Collections.swap(A, i, next);
        }
        return result;
    }

    public static List<Integer> computeRandomPermutationV2(int n) {
        List<Integer> permutation = IntStream.range(0, n).boxed().collect(Collectors.toList());
        A_05_12_RandomSampling.randomSampling(n, permutation);
        return permutation;
    }

    public static void main(String[] args) {
        List<Integer> list = computeRandomPermutationV2(10);
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}
