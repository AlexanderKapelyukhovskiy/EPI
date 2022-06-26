package com.alkapa.epi.A_11_searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class A_11_06_SearchIn2DSortedArray {
    public static boolean matrixSearch(List<List<Integer>> A, int x) {
        return matrixSearch(A, x, 0, 0, 4, 5);
    }

    public static boolean matrixSearch(List<List<Integer>> A, int x, int x1, int y1, int x2, int y2) {
        x1 = Math.min(A.size()-1, x1);
        x2 = Math.min(A.size()-1, x2);
        y1 = Math.min(A.get(x1).size()-1, y1);
        y2 = Math.min(A.get(x2).size()-1, y2);

        if (x1 == x2 && y1 == y2) {
            return A.get(x1).get(y1) == x;
        }

        if (x1 == x2) {
            return A.get(x1).get(y1) == x || A.get(x1).get(y2) == x;
        }

        if (y1 == y2) {
            return A.get(x1).get(y1) == x || A.get(x2).get(y1) == x;
        }
        if (x1 + 1 == x2 && y1 +1 == y2) {
            return A.get(x1).get(y1) == x || A.get(x2).get(y1) == x
                || A.get(x1).get(y2) == x || A.get(x2).get(y2) == x;
        }

        int midX = x1+(x2-x1)/2;
        int midY = y1+(y2-y1)/2;

        int a = A.get(midX).get(midY);

        if (a == x) {
            return true;
        }
        boolean inSideArrays =  matrixSearch(A, x, x1, midY +1, midX, y2)
                || matrixSearch(A, x, midX + 1, y1, x2, midY);
        if (inSideArrays) {
            return true;
        }

        if (x > a) {
            return matrixSearch(A, x, x1, y1, midX, midX);
        } else  {
            return matrixSearch(A, x, midX + 1, midY + 1, x2, y2);
        }
    }

    public static boolean matrixSearchV2(List<List<Integer>> A, int x) {
        int row = 0, col = A.get(0).size() -1;
        while (row < A.size() && col >= 0) {
            int a = A.get(row).get(col);
            if (x == a) {
                return true;
            } else if (x > a) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();

        List<Integer> c = new ArrayList<>();
        c.add(-1);
        c.add(1);
        c.add(3);
        c.add(3);
        c.add(6);
        c.add(8);
        A.add(c);

        c = new ArrayList<>();
        c.add(2);
        c.add(5);
        c.add(6);
        c.add(6);
        c.add(8);
        c.add(10);
        A.add(c);

        c = new ArrayList<>();
        c.add(4);
        c.add(5);
        c.add(6);
        c.add(8);
        c.add(9);
        c.add(12);
        A.add(c);

        c = new ArrayList<>();
        c.add(4);
        c.add(9);
        c.add(9);
        c.add(10);
        c.add(12);
        c.add(13);
        A.add(c);

        c = new ArrayList<>();
        c.add(6);
        c.add(21);
        c.add(22);
        c.add(24);
        c.add(25);
        c.add(40);
        A.add(c);

        System.out.println(matrixSearchV2(A, 7));
        System.out.println(matrixSearchV2(A, 8));
    }
}
