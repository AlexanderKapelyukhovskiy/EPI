package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.List;

public class A_05_04_AdvancingThroughoutArray {
    public static boolean canReachEnd(List<Integer> A) {
        Integer furthestIndex = 0;
        Integer lastIndex = A.size() - 1;
        for(int i = 0; i <= furthestIndex && furthestIndex < lastIndex ; i++) {
            if (furthestIndex < i + A.get(i)) {
                System.out.println(i);
            }
            furthestIndex = Math.max(furthestIndex, i + A.get(i));
        }
        return furthestIndex >= lastIndex;
    }

    public static void main(String[] args) {
        List<Integer> noWay = new ArrayList<>();
        noWay.add(3);
        noWay.add(3);
        noWay.add(1);
        noWay.add(0);
        noWay.add(1);
        noWay.add(0);
        noWay.add(1);
        System.out.println(canReachEnd(noWay));

        List<Integer> way = new ArrayList<>();
        way.add(2);
        way.add(4);
        way.add(1);
        way.add(1);
        way.add(0);
        way.add(2);
        way.add(3);
        System.out.println(canReachEnd(way));
    }
}
