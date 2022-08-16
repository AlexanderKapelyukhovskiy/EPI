package com.alkapa.epi.A_16_dynamic_programming;

public class A_16_00_ComputeFibonacciSequence {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int fib1 = 1;
        int fib2 = 1;
        int f = 2;
        for(int i = 2; i <= n; ++i) {
            f = fib1 + fib2;
            fib1 = fib2;
            fib2 = f;
        }
        return f;
    }

    public static void test(int n) {
        System.out.println(String.format("%d -> %d", n, fibonacci(n)));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            test(i);
        }
    }
}
