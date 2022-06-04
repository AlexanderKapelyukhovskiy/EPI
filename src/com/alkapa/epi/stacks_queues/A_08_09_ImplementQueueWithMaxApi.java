package com.alkapa.epi.stacks_queues;

public class A_08_09_ImplementQueueWithMaxApi {
    public static void main(String[] args) {
        QueueWithMax q = new QueueWithMax();

        q.enqueue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        q.dequeue();
        q.dequeue();
        q.dequeue();
        //q.dequeue();
        System.out.println(q.max());
    }
}
