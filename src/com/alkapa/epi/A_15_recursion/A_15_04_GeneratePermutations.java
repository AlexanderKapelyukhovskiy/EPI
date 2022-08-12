package com.alkapa.epi.A_15_recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A_15_04_GeneratePermutations {
    public static List<List<Integer>> generatePermutation(List<Integer> a) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.size(); ++i) {
            generatePermutationHelp(a.size(), a, new ArrayList<>(), result);
            System.out.println(i);
        }
        return result;
    }

    private static void generatePermutation(List<Integer> a, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == a.size()) {
            result.add(new ArrayList<>(permutation));
        } else {
            for (int i = permutation.size(); i < a.size(); ++i) {
                permutation.add(a.get(i));
                generatePermutation(a, permutation, result);
                permutation.remove(a.get(i));
            }
        }
    }

    private static void generatePermutationHelp(int n, List<Integer> input, List<Integer> output, List<List<Integer>> result) {
        if (output.size() == n - 1) {
            result.add(Stream.concat(output.stream(), input.stream()).collect(Collectors.toList()));
            return;
        }

        Integer v = input.get(0);
        input.remove(v);
        output.add(v);

        for (int i = 0; i < input.size(); i++) {
            generatePermutationHelp(n, input, output, result);
        }

        output.remove(v);
        input.add(v);
    }


    public static List<List<Integer>> permutations(List<Integer> A) {
        List<List<Integer>> result = new ArrayList<>();
        directPermutation(0, A, result);
        return result;
    }

    private static void directPermutation(int pos, List<Integer> A, List<List<Integer>> result) {
        if (pos == A.size() - 1) {
            result.add(new ArrayList<>(A));
            return;
        }

        for (int i = pos; i < A.size(); ++i) {
            Collections.swap(A, pos, i);
            directPermutation(pos + 1, A, result);
            Collections.swap(A, pos, i);
        }
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        //a.add(4);
        List<List<Integer>> res = permutations(a);
        for (List<Integer> r : res) {
            for (Integer i : r) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
