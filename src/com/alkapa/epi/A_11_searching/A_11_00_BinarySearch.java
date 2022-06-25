package com.alkapa.epi.A_11_searching;

import java.util.ArrayList;
import java.util.List;

public class A_11_00_BinarySearch {
    public static int bsearch(int t, List<Integer> A) {
        int L = 0, H = A.size() - 1;
        while (L <= H) {
            int M = L + (H - L) / 2;
            if (A.get(M) > t) {
                H = M - 1;
            } else if (A.get(M) == t) {
                return M;
            } else if (A.get(M) < t) {
                L = M + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(-14);
        A.add(-10);
        A.add(2);
        A.add(108);
        A.add(108);
        A.add(243);
        A.add(285);
        A.add(285);
        A.add(285);
        A.add(401);

        int pos = bsearch(285, A);
        System.out.println(pos);
    }
}
