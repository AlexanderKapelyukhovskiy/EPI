package com.alkapa.epi.A_15_recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A_15_05_GenerateThePowerSet {
    public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
        List<List<Integer>> resultSet = new ArrayList<>();
        
        generatePowerSet(0, inputSet, resultSet);
        resultSet.add(new ArrayList<>(Collections.EMPTY_LIST));
        return resultSet;
    }

    private static void generatePowerSet(int pos, List<Integer> A, List<List<Integer>> result) {
        if (pos >= A.size()) {
            return;
        }

        Integer v = A.get(pos);
        int size = result.size();
        for (int i = 0; i < size; ++i) {
            result.add(Stream.concat(result.get(i).stream(), List.of(v).stream()).collect(Collectors.toList()));
        }
        result.add(List.of(v));

        generatePowerSet(pos + 1, A, result);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);

        List<List<Integer>> res = generatePowerSet(A);
        for (List<Integer> r : res) {
            for (Integer i : r) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
