package com.alkapa.epi.A_11_searching;

import java.util.*;

public class A_11_08_FindTheKthLargestElement {
    public static int findKthLargest(int k, List<Integer> A) {
        return findKth(A, k, (a, b) -> Integer.compare(b, a));
    }

    public static int findKth(List<Integer> A, int k, Comparator<Integer> cmp) {
        int left = 0, right = A.size() - 1;
        Random r = new Random();
        while (left <= right) {
            int pivotIdx = r.nextInt(right - left + 1) + left;
            int newPivotIdx = partitionAroundPivot(left, right, pivotIdx, A, cmp);
            if (newPivotIdx == k - 1) {
                return A.get(newPivotIdx);
            } else if (newPivotIdx > k - 1) {
                right = newPivotIdx - 1;
            } else {
                left = newPivotIdx + 1;
            }

        }
        return 0;
    }

    private static int partitionAroundPivot(int left, int right, int pivotIdx,
                                            List<Integer> A, Comparator<Integer> cmp) {
        int pivotValue = A.get(pivotIdx);
        int newPivotIdx = left;

        Collections.swap(A, pivotIdx, right);
        for (int i = left; i < right; ++i) {
            if (cmp.compare(A.get(i), pivotValue) < 0) { // a > pivot
                Collections.swap(A, i, newPivotIdx++);
            }
        }
        Collections.swap(A, right, newPivotIdx);
        return newPivotIdx;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(1);
        A.add(5);
        A.add(4);

        int pos = findKthLargest(2, A);
        System.out.println(pos);
    }
}
