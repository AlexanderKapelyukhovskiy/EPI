package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.List;

public class A_05_20_PascalTriangle {
    public static List<List<Integer>> generatePascalTriangle(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                int value = j > 0 && j < i
                        ? pascalTriangle.get(i - 1).get(j) + pascalTriangle.get(i - 1).get(j - 1)
                        : 1;
                row.add(value);
            }
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }

    public static void main (String[] args) {
        List<List<Integer>> pascalTriangle = generatePascalTriangle(5);
        for (int i = 0; i < pascalTriangle.size(); i++) {
            for (int j = 0; j < pascalTriangle.get(i).size(); ++j) {
                System.out.println(pascalTriangle.get(i).get(j));
            }
        }
    }
}
