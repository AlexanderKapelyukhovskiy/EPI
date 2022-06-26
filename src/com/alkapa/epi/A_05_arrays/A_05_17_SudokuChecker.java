package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_05_17_SudokuChecker {

    public static boolean chatSudoku(List<List<Integer>> partialAssignment) {
        for (int i = 0; i < partialAssignment.size() - 1; ++i) {
            if (hasDuplications(partialAssignment, i, i + 1, 0, partialAssignment.size())) {
                return false;
            }
            if (hasDuplications(partialAssignment, 0, partialAssignment.size(), i, i + 1)) {
                return false;
            }
        }
        int regionSize = (int) Math.sqrt(partialAssignment.size());

        for (int i = 0; i < regionSize; ++i) {
            for (int j = 0; j < regionSize; ++j) {
                if (hasDuplications(
                        partialAssignment,
                        i * regionSize, (i + 1) * regionSize,
                        j * regionSize, (j + 1) * regionSize)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean hasDuplications(
            List<List<Integer>> partialAssignment,
            int startRow, int endRow, int startCol, int endCol) {

        List<Boolean> isPresent = new ArrayList<>(
                Collections.nCopies((endRow - startRow) * (endCol - startCol), false));

        for (int i = startRow; i < endRow; ++i) {
            for (int j = startCol; j < endCol; ++j) {
                Integer x = partialAssignment.get(i).get(j);
                if (x > 0) {
                    if (isPresent.get(x - 1)) {
                        return true;
                    } else {
                        isPresent.set(x - 1, true);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> partialAssignment = new ArrayList<>();
        List<Integer> line = new ArrayList<>();

        line.add(1);
        line.add(0);
        line.add(3);

        line.add(0);
        line.add(0);
        line.add(6);

        line.add(0);
        line.add(8);
        line.add(9);
        partialAssignment.add(line);

        System.out.println(hasDuplications(partialAssignment,0, 1, 0, 9));
    }
}
