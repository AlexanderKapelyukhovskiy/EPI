package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.List;

public class A_05_18_ComputeSpiralOrderingOfMatrix {
    public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix) {
        List<Integer> spiralOrdering = new ArrayList<>();
        for (int offset = 0; offset < Math.ceil(squareMatrix.size() * 0.5); ++offset) {
            matrixLayerInClockwise(squareMatrix, offset, spiralOrdering);
        }
        return spiralOrdering;
    }

    public static void matrixLayerInClockwise(
            List<List<Integer>> squareMatrix, int offset, List<Integer> spiralOrdering) {

        if (offset == squareMatrix.size() - offset - 1) {
            spiralOrdering.add(squareMatrix.get(offset).get(offset));
            return;
        }

        for (int j = offset; j < squareMatrix.size() - offset - 1; ++j) {
            spiralOrdering.add(squareMatrix.get(offset).get(j));
        }

        for (int i = offset; i < squareMatrix.size() - offset - 1; ++i) {
            spiralOrdering.add(squareMatrix.get(i).get(squareMatrix.size() - offset - 1));
        }

        for (int j = squareMatrix.size() - offset - 1; j > offset; --j) {
            spiralOrdering.add(squareMatrix.get(squareMatrix.size() - offset - 1).get(j));
        }

        for (int i = squareMatrix.size() - offset - 1; i > offset; --i) {
            spiralOrdering.add(squareMatrix.get(i).get(offset));
        }
    }

    public static void main(String[] args) {
        int size = 3;
        List<List<Integer>> squareMatrix = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            List<Integer> row = new ArrayList<>(size);
            for (int j = 0; j < size; ++j) {
                row.add(size * i + j + 1);
            }
            squareMatrix.add(row);
        }

        List<Integer> spiralOrdering = matrixInSpiralOrder(squareMatrix);

        for (int i : spiralOrdering) {
            System.out.println(i);
        }
    }
}