package com.alkapa.epi.A_08_stacks_queues;

public class A_08_08_ImplementQueueUsingStack {
    public static void main(String[] args) {
        QueueOnStacks q = new QueueOnStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        q.enqueue(5);
        q.enqueue(6);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
