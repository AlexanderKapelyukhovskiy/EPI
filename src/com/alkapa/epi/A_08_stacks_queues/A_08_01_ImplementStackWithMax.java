package com.alkapa.epi.A_08_stacks_queues;

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
