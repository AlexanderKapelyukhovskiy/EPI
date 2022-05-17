package com.alkapa.epi.arrays;

import java.util.ArrayList;
import java.util.List;

public class A_05_02_IncrementInteger {
    public static void inrement(List<Integer> list){
        int add = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 9 && add == 1) {
                list.set(i, 0);
            } else {
                list.set(i, list.get(i) + add);
                add = 0;
                break;
            }
        }
        if (add == 1) {
            list.add(0, 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> v = new ArrayList<Integer>();
        v.add(9);
        v.add(9);
        v.add(9);

        inrement(v);
        for (int i: v) {
            System.out.println(i);
        }
    }
}
