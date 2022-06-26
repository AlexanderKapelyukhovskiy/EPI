package com.alkapa.epi.A_11_searching;

import java.util.ArrayList;
import java.util.List;

public class A_11_03_SearchCyclicallySortedArray {
    public static int searchSmallest(List<Integer> A) {
        return searchSmallestHelper(A, 0, A.size() - 1);
    }

    public static int searchSmallestHelper(List<Integer> A, int L, int H) {
        if (L == H) {
            return L;
        }

        if (A.get(L) < A.get(H)) {
            return L;
        }

        int M = L + (H - L) / 2;

        int leftMin = searchSmallestHelper(A, L, M);
        int rightMin = searchSmallestHelper(A, M + 1, H);

        if (A.get(leftMin) < A.get(rightMin)) {
            return leftMin;
        } else {
            return rightMin;
        }
    }

    public static int searchSmallestV2(List<Integer> A) {
        int left = 0, right = A.size() - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (A.get(left) > A.get(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(378);
        A.add(478);
        A.add(550);
        A.add(631);
        A.add(103);
        A.add(203);
        A.add(220);
        A.add(234);
        A.add(279);
        A.add(368);

        int pos = searchSmallestV2(A);
        System.out.println(A.get(pos));
    }
}
