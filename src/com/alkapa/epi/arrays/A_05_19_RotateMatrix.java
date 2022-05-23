package com.alkapa.epi.arrays;

import java.util.ArrayList;
import java.util.List;

public class A_05_19_RotateMatrix {
    public static void rotateMatrix(List<List<Integer>> squareMatrix) {
        int size = squareMatrix.size() - 1;
        for (int i = 0; i < squareMatrix.size() / 2; ++i) {
            for (int j = i; j < size - i; ++j) {
                int temp1 = squareMatrix.get(size - j).get(i);
                int temp2 = squareMatrix.get(size - i).get(size - j);
                int temp3 = squareMatrix.get(j).get(size - i);
                int temp4 = squareMatrix.get(i).get(j);

                squareMatrix.get(i).set(j, temp1);
                squareMatrix.get(size - j).set(i, temp2);
                squareMatrix.get(size - i).set(size - j, temp3);
                squareMatrix.get(j).set(size - i, temp4);
            }
        }
    }

    public static class RotateMatrix {
        private List<List<Integer>> matrix;

        public RotateMatrix(List<List<Integer>> matrix) {
            this.matrix = matrix;
        }

        public Integer getItem(int i, int j) {
            return this.matrix.get(matrix.size() - j - 1).get(i);
        }

        public void setTimer(int i, int j, int value) {
            this.matrix.get(matrix.size() - j - 1).set(i, value);
        }
    }

    public static void main (String[] args) {
        int size = 4;
        List<List<Integer>> squareMatrix = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            List<Integer> row = new ArrayList<>(size);
            for (int j = 0; j < size; ++j) {
                row.add(size * i + j + 1);
            }
            squareMatrix.add(row);
        }

        RotateMatrix rotatedMatrix = new RotateMatrix(squareMatrix);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.println(rotatedMatrix.getItem(i, j));
            }
        }

        System.out.println();
        rotateMatrix(squareMatrix);

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.println(squareMatrix.get(i).get(j));
            }
        }
    }
}
