package com.alkapa.epi.A_10_heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class A_10_02_SortIncreasingDecreasingArray {
    private static class FirstItemPerArrayDescriptor {
        int arrayIndex;
        int value;
        public FirstItemPerArrayDescriptor(int value, int arrayIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
        }
    }

    private static class SubArrayPositionDescriptor {
        int currentIndex;
        boolean increasing;
        int limit;

        public SubArrayPositionDescriptor(int currentIndex, boolean increasing, int limit) {
            this.currentIndex = currentIndex;
            this.increasing = increasing;
            this.limit = limit;
        }

        public int next() {
            if (increasing){
                return this.currentIndex++;
            }
            return this.currentIndex--;
        }

        public boolean hasNext() {
            return this.increasing ? this.currentIndex <= this.limit : this.currentIndex >= limit;
        }
    }

    public static List<Integer> sortIncreasingDecreasingArray(List<Integer> A) {
        if (A == null || A.size() <= 1) {
            return A;
        }
        List<SubArrayPositionDescriptor> sameDirectionSubArraysDescriptors = new ArrayList<>();
        boolean increase = A.get(0) < A.get(1);

        int prev = 0;
        for (int i = 0; i < A.size() - 1; ++i) {
            if (increase && (A.get(i) > A.get(i + 1))) {
                sameDirectionSubArraysDescriptors.add(new SubArrayPositionDescriptor(prev, true, i ));
                increase = !increase;
                prev = i+1;
            } else if (!increase && (A.get(i) < A.get(i + 1))) {
                sameDirectionSubArraysDescriptors.add(new SubArrayPositionDescriptor(i, false, prev));
                increase = !increase;
                prev = i+1;
            }
        }
        if (increase) {
            sameDirectionSubArraysDescriptors.add(
                new SubArrayPositionDescriptor(prev, true, A.size()-1 ));
        } else {
            sameDirectionSubArraysDescriptors.add(
                new SubArrayPositionDescriptor(A.size()-1, false,  prev));
        }


        PriorityQueue<FirstItemPerArrayDescriptor> priorityQueue
            = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.value, e2.value));

        for(int i= 0; i < sameDirectionSubArraysDescriptors.size(); ++i) {
            Integer v = A.get(sameDirectionSubArraysDescriptors.get(i).next());
            priorityQueue.add(new FirstItemPerArrayDescriptor(v, i));
        }

        List<Integer> res = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            FirstItemPerArrayDescriptor e = priorityQueue.poll();
            res.add(e.value);
            if (sameDirectionSubArraysDescriptors.get(e.arrayIndex).hasNext()) {
                int nextValue = A.get(sameDirectionSubArraysDescriptors.get(e.arrayIndex).next());
                priorityQueue.add(new FirstItemPerArrayDescriptor(nextValue, e.arrayIndex));
            }
        }

        return res;


        /*for (int i = 0; i < sameDirectionSubArraysDescriptors.size(); ++i) {
            List<Integer> list = new ArrayList<>();
            ArrayDef def = sameDirectionSubArraysDescriptors.get(i);
            while (def.hasNext()) {
                list.add(A.get(def.next()));
            }
            all.add(list);
        }

        return A_10_01_MergeSortedFiles.mergeSortedArrays(all);*/
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(57);
        list.add(131);
        list.add(493);
        list.add(294);
        list.add(221);
        list.add(339);
        list.add(418);
        list.add(452);
        list.add(442);
        list.add(190);

        List<Integer> res = sortIncreasingDecreasingArray(list);

        for(Integer i : res) {
            System.out.println(i);
        }
    }
}
