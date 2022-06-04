package com.alkapa.epi.stacks_queues;

public class QueueWithMaxOnTwoStacksWithMax {

    private StackWithMax enqueueStack = new StackWithMax();
    private StackWithMax dequeueStack = new StackWithMax();

    public void enqueue(Integer x) {
        enqueueStack.push(x);
    }

    public Integer dequeue() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    public Integer max() {
        return Math.max(enqueueStack.max(), dequeueStack.max());
    }
}
