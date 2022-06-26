package com.alkapa.epi.A_10_heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class A_10_00_TopK {
    public static List<String> topK(int k, Iterator<String> iter) {
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        while (iter.hasNext()) {
            String item = iter.next();
            if (minHeap.size() < k) {
                minHeap.add(item);
            } else if (minHeap.peek().length() > item.length()) {
                minHeap.add(item);
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] arg) {
        List<String> list = new ArrayList<>();
        list.add("aaaaaaaaa");
        list.add("aaaaaaaa");
        list.add("aaaaaaa");
        list.add("aaaaaa");
        list.add("aaaa");
        list.add("aaa");

        List<String> res = topK(3, list.listIterator());
        System.out.println();
        for (String s : res) {
            System.out.println(s);
        }
    }
}
