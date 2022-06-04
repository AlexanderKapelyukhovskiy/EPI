package com.alkapa.epi.stacks_queues;

public class A_08_07_ImplementCircularQueue {
    public static void main(String[] arg) {
        CircularQueueV2 cq = new CircularQueueV2(5);

        cq.enqueue(10);
        cq.enqueue(11);
        cq.enqueue(12);
        cq.enqueue(13);
        cq.enqueue(14);
        cq.dequeue();
        cq.dequeue();
        cq.enqueue(15);
        try{
            cq.dequeue();
            cq.enqueue(16);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        cq.enqueue(17);
        cq.enqueue(18);
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        try {
            cq.dequeue();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        cq.enqueue(15);
        int val = cq.dequeue();
        System.out.println(val);
    }
}
