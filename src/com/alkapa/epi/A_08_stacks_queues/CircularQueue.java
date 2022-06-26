package com.alkapa.epi.A_08_stacks_queues;

public class CircularQueue {
    int head, tail, size, length;
    int[] data;

    public CircularQueue(int size) {
        this.data = new int[size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.length = 0;
    }

    public void enqueue(int val) {
        if (length >= size) {
            throw new IllegalArgumentException("Queue is full");
        }
        this.data[this.tail++] = val;
        this.length++;

        if (this.tail == size) {
            this.tail = 0;
        }
    }

    public int dequeue() {
        if (length <= 0) {
            throw new IllegalArgumentException("Queue is empty");
        }
        int val = this.data[head++];
        this.length--;
        if (this.head == size) {
            this.head = 0;
        }
        return val;
    }
}
