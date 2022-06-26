package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.List;

public class A_05_06_BuyAndSellStock {
    public static Integer getMaxProfit(List<Integer> A) {
        if (A.isEmpty()) {
            return 0;
        }

        Integer max = 0, min = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            if (min > A.get(i)) {
                int smax = 0;
                for( int j = i + 1; j < A.size() - 1; j ++) {
                    if (smax < A.get(j) - A.get(i)) {
                        smax = A.get(j) - A.get(i);
                    }
                }
                if (smax > max) {
                    min = A.get(i);
                    max = smax;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> history = new ArrayList<>();

        history.add(310);
        history.add(315);
        history.add(275);
        history.add(295);
        history.add(260);
        history.add(290);
        history.add(230);
        history.add(255);
        history.add(250);

        int bestProfit = getMaxProfit(history);

        System.out.println(bestProfit);
    }
}
