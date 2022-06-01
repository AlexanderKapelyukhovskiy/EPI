package com.alkapa.epi.stacks_queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class A_08_01_ImplementStackWithMax {
    public static void main(String[] args) {
        StackWithMax stack  = new StackWithMax();
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(String.format("%d %s", stack.max(), stack.pop()));
        System.out.println(String.format("%d %s", stack.max(), stack.pop()));
        System.out.println(String.format("%d %s", stack.max(), stack.pop()));
        System.out.println(String.format("%d %s", stack.max(), stack.pop()));
        System.out.println(String.format("%d %s", stack.max(), stack.pop()));
    }
}
