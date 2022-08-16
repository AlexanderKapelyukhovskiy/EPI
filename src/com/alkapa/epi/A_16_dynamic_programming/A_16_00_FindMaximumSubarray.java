package com.alkapa.epi.A_16_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class A_16_00_FindMaximumSubarray {
    public static int findMaximumSubarray(List<Integer> A) {
        int maxSeen = 0, maxEnd = 0;
        for(int a : A){
            maxEnd = Math.max(a, maxEnd + a);
            maxSeen = Math.max(maxSeen, maxEnd);
        }
        return maxSeen;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
//        A.add(9);
//        A.add(-8);
//        A.add(10);
        A.add(-2);
        A.add(3);
        A.add(1);
        A.add(-7);
        A.add(3);
        A.add(2);
        A.add(-1);
        int max = findMaximumSubarray(A);
        System.out.println(max);
    }
}
