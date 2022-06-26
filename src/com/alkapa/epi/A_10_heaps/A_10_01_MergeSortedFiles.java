package com.alkapa.epi.A_10_heaps;


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class A_10_01_MergeSortedFiles {
    private static class ArrayEntry {
        public Integer value;
        public Integer index;
        public Integer fileIndex;

        public ArrayEntry(Integer value, Integer index, Integer fileIndex) {
            this.value = value;
            this.index = index;
            this.fileIndex = fileIndex;
        }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {
        PriorityQueue<ArrayEntry> priorityQueue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.value, e2.value));
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < arrays.size(); ++i) {
            if (arrays.get(i).size() > 0) {
                priorityQueue.add(new ArrayEntry(arrays.get(i).get(0), 0, i));
            }
        }

        while (!priorityQueue.isEmpty()) {
            ArrayEntry minEntry = priorityQueue.poll();
            List<Integer> currentArray = arrays.get(minEntry.fileIndex);
            int nextIndex = minEntry.index + 1;

            res.add(minEntry.value);
            if (minEntry.index < currentArray.size() - 1) {
                priorityQueue.add(
                    new ArrayEntry(
                        currentArray.get(nextIndex),
                        nextIndex,
                        minEntry.fileIndex
                    )
                );
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(5);
        a.add(7);
        list.add(a);
        a = new ArrayList<>();
        a.add(0);
        a.add(6);
        list.add(a);
        a = new ArrayList<>();
        a.add(0);
        a.add(6);
        a.add(28);
        list.add(a);

        List<Integer> res = mergeSortedArrays(list);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
