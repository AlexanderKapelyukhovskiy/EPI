package com.alkapa.epi.A_15_recursion;

import java.util.ArrayList;
import java.util.List;

public class A_15_03_GenerateAllNonattackingPlacementsOfNQueens {
    public static List<List<Integer>> nQueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        solveNQueens(n, 0, new ArrayList<>(), result);
        return result;
    }

    private static void solveNQueens(int n, int row, List<Integer> colPlacement, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(colPlacement));
        } else {
            for (int col = 0; col < n; ++col) {
                colPlacement.add(col);
                if (isValid(colPlacement)) {
                    solveNQueens(n, row + 1, colPlacement, result);
                }
                colPlacement.remove(colPlacement.size() - 1);
            }
        }
    }

    private static boolean isValid(List<Integer> colPlacement) {
        int rowId = colPlacement.size() - 1;
        for (int i = 0; i < rowId; ++i) {
            int diff = Math.abs(colPlacement.get(i) - colPlacement.get(rowId));
            if (diff == 0 || diff == rowId - i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> results = nQueens(4);
        for (List<Integer> r : results) {
            for (Integer i : r) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
