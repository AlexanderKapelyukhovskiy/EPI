package com.alkapa.epi.heaps;

import java.util.*;

public class A_10_06_ComputeTheKLargestElementsInMaxHeap {
    public static List<Integer> getKlargestElement(List<Integer> A, int k) {
        List<Integer> L = new ArrayList<>();
        Deque<Integer> prev = new ArrayDeque<>();
        getKlargestElementHelper(0, prev, A, L, k);
        return L;
    }
    public static void getKlargestElementHelper(int i, Deque<Integer> prev, List<Integer> A, List<Integer> L, int k) {
        if (i >= A.size() || L.size() >= k) {
            return;
        }

        L.add(A.get(i));
        //compare prev, left, right

        if ((2*i +1) >= A.size() && !prev.isEmpty()) {
            getKlargestElementHelper(prev.pop(), prev, A, L, k);
            return;
        }

        if ((2*i +2) >= A.size()) {
            if (!prev.isEmpty() && A.get(prev.peek()) > A.get(2*i + 1)) {
                 int next = prev.pop();
                 prev.push(2*i + 1);
                getKlargestElementHelper(next, prev, A, L, k);
            } else {
                getKlargestElementHelper(2*i + 1, prev, A, L, k);
            }
            return;
        }
        int largergetChild = A.get(2*i+1) > A.get(2*i +2) ? 2*i + 1 : 2*i + 2;
        int smallestChild = A.get(2*i+1) < A.get(2*i +2) ? 2*i + 1 : 2*i + 2;

        if (prev.isEmpty()) {
            prev.push(smallestChild);
            getKlargestElementHelper(largergetChild, prev, A, L, k);
            return;
        }

        if (A.get(prev.peek()) > A.get(largergetChild)) {
            int next = prev.pop();
            prev.push(smallestChild);
            prev.push(largergetChild);
            getKlargestElementHelper(next, prev, A, L, k);
        } else if (A.get(prev.peek()) > A.get(smallestChild)){
            int prevI = prev.pop();
            prev.push(smallestChild);
            prev.push(prevI);
            getKlargestElementHelper(largergetChild, prev, A, L, k);
        } else {
            prev.push(smallestChild);
            getKlargestElementHelper(largergetChild, prev, A, L, k);
        }
    }

    private static class HeapEntry{
        Integer index;
        Integer value;
        public HeapEntry(Integer index, Integer value) {
            this.index = index;
            this.value = value;
        }
    }

    public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {
        PriorityQueue<HeapEntry> maxCandidates = new PriorityQueue<>((a,b) -> Integer.compare(b.value, a.value));
        maxCandidates.add(new HeapEntry(0, A.get(0)));
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; ++i) {
            HeapEntry entry = maxCandidates.poll();
            res.add(entry.value);
            int left = 2*i + 1;
            int right = left + 1;
            if (left < A.size()) {
                maxCandidates.add(new HeapEntry(left, A.get(left)));
            }
            if (right < A.size()) {
                maxCandidates.add(new HeapEntry(right, A.get(right)));
            }
        }

        return res;
    }

    public static void main(String[] arg) {
        List<Integer> A = new ArrayList<>();
        A.add(561);
        A.add(314);
        A.add(401);
        A.add(28);
        A.add(156);
        A.add(359);
        A.add(271);
        A.add(11);
        A.add(3);

        List<Integer> res = kLargestInBinaryHeap(A,9);//getKlargestElement(A, 5);
        for(Integer i : res) {
            System.out.println(i);
        }
    }
}

