package com.alkapa.epi.stacks_queues;

import java.util.Arrays;
import java.util.Collections;

public class CircularQueueV2 {

    private int head = 0, tail = 0, numQueueElements = 0;
    private static final int SCALE_FACTOR = 2;

    private Integer[] entries;

    public CircularQueueV2(int capacity) {
        entries = new Integer[capacity];
    }

    public void enqueue(Integer x) {
        if (numQueueElements == entries.length) {
            Collections.rotate(Arrays.asList(entries), -head);
            head = 0;
            tail = numQueueElements;
            entries = Arrays.copyOf(entries, SCALE_FACTOR * numQueueElements);
        }
        entries[tail] = x;
        tail = (tail + 1) % entries.length;
        numQueueElements++;
    }

    public int dequeue() {
        int v = entries[head];
        head = (head + 1) % entries.length;
        numQueueElements--;
        return v;
    }
}
