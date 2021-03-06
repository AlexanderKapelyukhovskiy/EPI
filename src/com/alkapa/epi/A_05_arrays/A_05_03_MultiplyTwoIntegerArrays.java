package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_05_03_MultiplyTwoIntegerArrays {
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        int sign = num1.get(0) < 0 ^ num2.get(0) < 0 ? -1 : 1;

        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.size() + num2.size(), 0));

        for (int i = num1.size() - 1; i >= 0; --i) {
            for (int j = num2.size() - 1; j >= 0; --j) {
                result.set(i + j + 1, result.get(i + j + 1) + num1.get(i) * num2.get(j));
                result.set(i + j, result.get(i + j) + result.get(i + j + 1) / 10);
                result.set(i + j + 1, result.get(i + j + 1) % 10);
            }
        }

        int firstNotZero = 0;

        while (firstNotZero < result.size() && result.get(firstNotZero) == 0) {
            ++firstNotZero;
        }

        result = result.subList(firstNotZero, result.size());

        if (result.isEmpty()) {
            return List.of(0);
        }

        result.set(0, result.get(0) * sign);

        return result;
    }

    public static void main(String[] args) {
        List<Integer> num1 = new ArrayList<>();
        num1.add(9);
        num1.add(9);
        num1.add(9);
        List<Integer> num2 = new ArrayList<>();
        num2.add(9);
        num2.add(9);
        num2.add(9);

        for (Integer i : multiply(num1, num2)) {
            System.out.println(i);
        }
    }
}
