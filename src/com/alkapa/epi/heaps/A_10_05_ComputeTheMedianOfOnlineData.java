package com.alkapa.epi.heaps;

import java.util.*;

public class A_10_05_ComputeTheMedianOfOnlineData {
    public static List<Double> computeMedian(Iterator<Integer> sequence) {
        PriorityQueue<Integer> minOfHight = new PriorityQueue<>();
        PriorityQueue<Integer> maxOfLow = new PriorityQueue<>(16, Collections.reverseOrder());
        List<Double> res = new ArrayList<>();
        int i = 1;
        while (sequence.hasNext()) {
            Integer val = sequence.next();
            minOfHight.add(val);
            maxOfLow.add(minOfHight.poll());
            if (maxOfLow.size() > minOfHight.size()) {
                minOfHight.add(maxOfLow.poll());
            }
            res.add(minOfHight.size() == maxOfLow.size() ? (minOfHight.peek() + maxOfLow.peek()) / 2.0 : minOfHight.peek());
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);
        list.add(3);
        list.add(5);
        list.add(2);
        list.add(0);
        list.add(1);

        List<Double> res = computeMedian(list.listIterator());
        for (Double i : res) {
            System.out.println(i);
        }
    }
}
