package com.alkapa.epi.A_11_searching;

public class A_11_04_ComputeIntegerSquareRoot {
    public static int intSquareRoot(int val) {
        int sqrt = (int)Math.sqrt(val);
        return sqrt;
    }

    public static int intSquareRootV2(int val) {
        int left = 0, right = val;
        while (left <= right) {
            int middle = left + (right-left)/2;
            int sqr = middle * middle;
            if (sqr < val) {
                left = middle + 1;
            } if (sqr == val) {
              return middle;
            } else {
                right = middle-1;
            }
        }
        return left * left == val? left  : left - 1;
    }

    public static void test(int val) {
        System.out.println(String.format("%d -> %d", val, intSquareRootV2(val)));
    }

    public static void main (String[] args) {
        test(4);
        test(16);
        test(300);
    }
}
