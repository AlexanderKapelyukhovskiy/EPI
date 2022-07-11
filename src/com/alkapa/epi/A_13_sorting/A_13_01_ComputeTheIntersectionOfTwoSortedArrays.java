package com.alkapa.epi.A_13_sorting;

import java.util.ArrayList;
import java.util.List;

public class A_13_01_ComputeTheIntersectionOfTwoSortedArrays {
    public static List<Integer> intersectTwoSortedArrays(List<Integer> A, List<Integer> B) {
        int a=0, b=0;
        List<Integer> result = new ArrayList<>();
        while (a<A.size() && b<B.size()) {
            if (A.get(a) == B.get(b)) {
                if (result.isEmpty() || A.get(a) != result.get(result.size() -1)) {
                    result.add(A.get(a));
                }

                a++;
                b++;
            }else if (A.get(a) > B.get(b)) {
                b++;
            } else {
                a++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(3);
        A.add(3);
        A.add(5);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(7);
        A.add(8);
        A.add(12);

        List<Integer> B = new ArrayList<>();
        B.add(5);
        B.add(5);
        B.add(6);
        B.add(8);
        B.add(8);
        B.add(9);
        B.add(10);
        B.add(10);

        List<Integer> res = intersectTwoSortedArrays(A, B);
        for(Integer r : res) {
            System.out.println(r);
        }
    }
}
