package com.alkapa.epi.A_11_searching;

import java.util.ArrayList;
import java.util.List;

public class A_11_02_SearchSortedArrayForEntryEqualToItsIndex {
    public static List<Integer> searchEntriesEqualToItsIndexes(List<Integer> A) {
        List<Integer> res = new ArrayList<>();
        searchEntriesEqualToItsIndexesHelper(A, 0, A.size()-1, res);
        return res;
    }

    public static void searchEntriesEqualToItsIndexesHelper(List<Integer> A, int L, int H, List<Integer> res) {
        if (L > H) {
            return;
        }
        int M = L + (H - L) / 2;
        if (A.get(M) == M) {
            res.add(M);
        }

        if (M + 1 <= H && A.get(M + 1) <= M + 1) {
            searchEntriesEqualToItsIndexesHelper(A, M + 1, H, res);
        }
        if (A.get(L) <= L) {
            searchEntriesEqualToItsIndexesHelper(A, L, M - 1, res);
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(-2);
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(6);
        A.add(7);
        A.add(9);

        List<Integer> res = searchEntriesEqualToItsIndexes(A);

        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
