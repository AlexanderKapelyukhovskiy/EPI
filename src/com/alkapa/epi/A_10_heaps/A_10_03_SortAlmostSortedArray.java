package com.alkapa.epi.A_10_heaps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A_10_03_SortAlmostSortedArray {
    public static List<Integer> sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        List<Integer> res = new ArrayList<>();

        for (int i=0; i < k && sequence.hasNext(); ++i) {
            minHeap.add(sequence.next());
        }

        while (sequence.hasNext()) {
            minHeap.add(sequence.next());
            res.add(minHeap.poll());
        }

        /*while(!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }*/

        res.addAll(
            Stream.generate(minHeap::poll)
                .limit(k)
                .collect(Collectors.toList())
        );

        return res;
    }

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(3);
        data.add(2);
        data.add(4);
        data.add(5);
        data.add(7);

        List<Integer> res = sortApproximatelySortedData(data.listIterator(), 2);
        for(Integer i : res) {
            System.out.println(i);
        }
    }
}
