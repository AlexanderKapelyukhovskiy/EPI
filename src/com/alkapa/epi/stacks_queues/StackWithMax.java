package com.alkapa.epi.stacks_queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackWithMax {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> max = new ArrayDeque<>();

    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    public Integer pop() {
        Integer element = this.stack.pop();
        if (element == this.max.peek()) {
            this.max.pop();
        }
        return element;
    }

    public void push(Integer val) {
        if (this.max.isEmpty() || val > this.max.peek()) {
            this.max.push(val);
        }
        this.stack.push(val);
    }

    public Integer max() {
        return this.max.peek();
    }
}
