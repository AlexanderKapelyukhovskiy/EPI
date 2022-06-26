package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.List;

public class A_05_05_RemoveDuplicates {
    public static int removeDuplicates(List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }
        int writeIndex = 1;
        for( int i = 1; i < A.size(); ++i) {
            if(!A.get(writeIndex - 1).equals(A.get(i))) {
                A.set(writeIndex++, A.get(i));
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();

        A.add(1);
        A.add(5);
        A.add(5);
        A.add(7);
        A.add(7);
        A.add(7);
        A.add(11);
        A.add(11);
        A.add(12);

        removeDuplicates(A);

        for (Integer i : A) {
            System.out.println(i);
        }
    }
}
