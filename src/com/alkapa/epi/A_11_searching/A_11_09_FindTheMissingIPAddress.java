package com.alkapa.epi.A_11_searching;

import java.util.BitSet;
import java.util.Iterator;

public class A_11_09_FindTheMissingIPAddress {
    public static int findMissingElement(Iterable<Integer> stream) {
        final int NUM_BUCKET = 1 << 16;
        int[] counter = new int[NUM_BUCKET];
        Iterator<Integer> s = stream.iterator();
        while (s.hasNext()) {
            int idx = s.next() >>> 16;
            ++counter[idx];
        }

        final int BUCKET_CAPACITY = 1 << 16;
        int candidateBucket = 0;
        for(int i = 0; i < NUM_BUCKET; ++i) {
            if (counter[i] < BUCKET_CAPACITY) {
                candidateBucket = i;
                break;
            }
        }
        BitSet  candidates = new BitSet(BUCKET_CAPACITY);
        s = stream.iterator();

        while (s.hasNext()) {
            int x = s.next();
            int upperPartX = x >>> 16;
            if (candidateBucket == upperPartX) {
                int lowerPartX = ((1 << 16) - 1) & x;
                candidates.set(lowerPartX);
            }
        }

        for(int i = 0; i < BUCKET_CAPACITY; ++i) {
            if (!candidates.get(i)) {
                return (candidateBucket << 16) | i;
            }
        }
    }
}
