package com.alkapa.epi.A_08_stacks_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueWithMax {
    private Deque<Integer> maxStack = new ArrayDeque<>();
    private Queue<Integer> queue = new ArrayDeque<>();

    public void enqueue(Integer x) {
        while (!maxStack.isEmpty() && maxStack.peekLast() < x) {
            maxStack.removeLast();
        }
        maxStack.addLast(x);
        queue.add(x);
    }

    public Integer dequeue() {
        if (queue.peek() == maxStack.peekFirst()) {
            maxStack.removeFirst();
        }
        return queue.poll();
    }

    public Integer max() {
        return maxStack.peekFirst();
    }
}