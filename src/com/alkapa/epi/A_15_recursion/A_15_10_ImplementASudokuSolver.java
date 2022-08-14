package com.alkapa.epi.A_15_recursion;

import java.util.List;

public class A_15_10_ImplementASudokuSolver {
    public static boolean solveSudoku(List<List<Integer>> partialAssignment) {
        return solvePartialSudoku(0, 0, partialAssignment);
    }

    private static boolean solvePartialSudoku(int i, int j, List<List<Integer>> partialAssignment) {
        if (i == partialAssignment.size()) {
            i = 0;
            if (++j == partialAssignment.get(i).size()) {
                return true;
            }
        }

        if (partialAssignment.get(i).get(j) != 0) {
            return solvePartialSudoku(i+ 1, j, partialAssignment);
        }

        for(int val = 1; val < partialAssignment.size(); ++val) {
            if (validToAddVal(partialAssignment, i, j, val)) {
                partialAssignment.get(i).set(j, val);
                if (solvePartialSudoku(i + 1, j, partialAssignment)) {
                    return true;
                }
            }
        }
        partialAssignment.get(i).set(j, 0);
        return false;
    }

    private static boolean validToAddVal(List<List<Integer>> partialAssignment, int i, int j, int val) {
        //check row constraint
        if (partialAssignment.stream().anyMatch(row -> row.get(j) == val)) {
            return false;
        }

        //check col constraint
        if (partialAssignment.get(i).contains(val)) {
            return false;
        }

        int regionSize = (int) Math.sqrt(partialAssignment.size());
        int I = i / regionSize, J = j / regionSize;

        for (int ii = 0; ii < regionSize; ++ii) {
            for (int jj = 0; jj < regionSize; ++jj) {
                if (partialAssignment.get(regionSize * I + ii).get(regionSize * J + jj) == val) {
                    return false;
                }
            }
        }
        return true;
    }

}
