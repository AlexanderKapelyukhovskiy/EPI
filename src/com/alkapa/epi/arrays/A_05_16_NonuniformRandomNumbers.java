package com.alkapa.epi.arrays;

import java.util.*;

public class A_05_16_NonuniformRandomNumbers {
    public static int nonuniformRandomNumberGenerator(List<Integer> numbers, List<Double> probabilities) {
        List<Double> prefixSumOfProbabilities = new ArrayList<>();

        probabilities.stream().reduce(0.0, (left, right) -> {
            prefixSumOfProbabilities.add(left + right);
            return left + right;
        });

        Random r = new Random();
        Double uniform01 = r.nextDouble();

        int idx = Collections.binarySearch(prefixSumOfProbabilities, uniform01);

        if (idx < 0) {
            int intervalIndex = Math.abs(idx) - 1;
            return numbers.get(intervalIndex);
        } else {
            return numbers.get(idx);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        /*numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);*/

        List<Double> probabilities = new ArrayList<Double>();
        probabilities.add(0.1);
        probabilities.add(0.2);
        probabilities.add(0.3);
        probabilities.add(0.4);

        System.out.println(nonuniformRandomNumberGenerator(numbers, probabilities));
    }
}

