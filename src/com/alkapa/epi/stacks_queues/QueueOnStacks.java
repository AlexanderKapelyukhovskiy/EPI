package com.alkapa.epi.stacks_queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueOnStacks {
    private Deque<Integer> enqueueStack = new ArrayDeque<>();
    private  Deque<Integer> dequeueStack = new ArrayDeque<>();

    public void enqueue(Integer x) {
        enqueueStack.push(x);
    }

    public Integer dequeue() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                Integer x = enqueueStack.pop();
                dequeueStack.push(x);
            }
        }
        Integer x = dequeueStack.pop();
        return x;
    }
}
