package com.alkapa.epi.A_13_sorting;

import java.util.ArrayList;
import java.util.List;

public class A_13_03_ComputeTheHIndex {
    public static int hIndex(List<Integer> citations) {
        citations.sort((a, b) -> a.compareTo(b));
        int n = citations.size() ;
        for (int i = 0; i < citations.size(); ++i) {
            if (citations.get(i) >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> citations = new ArrayList<>();
        citations.add(1);
        citations.add(4);
        citations.add(1);
        citations.add(4);
        citations.add(2);
        citations.add(1);
        citations.add(3);
        citations.add(5);
        citations.add(6);
        int hIndex = hIndex(citations);
        System.out.println(hIndex);
    }
}

