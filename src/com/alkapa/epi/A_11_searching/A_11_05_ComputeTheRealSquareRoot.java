package com.alkapa.epi.A_11_searching;

public class A_11_05_ComputeTheRealSquareRoot {
    public static double squareRoot(double root) {
        double left = 0, right = root;
        double middle =  left + (right - left) / 2.0;
        while (Math.abs(root - middle*middle) >= 0.0000001) {
            middle = left + (right - left) / 2.0;
            double sqr = middle * middle;
            if (sqr < root) {
                left = middle;
            } else if (sqr == root) {
                return middle;
            } else {
                right = middle;
            }
        }
        return left + (right - left) / 2.0;
    }

    public static double squareRootV2(double x) {
        double left, right;
        if (x < 1.0) {
            left = x;
            right = 1.0;
        } else {
            left = 1.0;
            right = x;
        }
        int count = 0;
        while (compare(left, right) != Ordering.EQUAL) {
            count ++;
            double mid = left + (right - left)/2.0;
            double midSquare = mid * mid;
            if (compare(midSquare, x) == Ordering.EQUAL){
                left = mid;
                break;
            }
            if (compare(midSquare, x) == Ordering.LARGER) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(count);
        return left;
    }

    private enum Ordering {SMALLER, EQUAL, LARGER}

    private static Ordering compare(double a, double b) {
        final double EPSILON = 0.00000001;
        double diff = (a - b) / Math.max(Math.abs(a), Math.abs(b));
        return diff < - EPSILON ? Ordering.SMALLER :
                (diff > EPSILON) ? Ordering.LARGER : Ordering.EQUAL;
    }

    public static void test(double val) {
        System.out.println(String.format("squareRoot(%f) = %021.19f", val, squareRootV2(val)));
    }

    public static void main(String[] args) {
        test(300);
        test(301);
        test(302);
        test(303);
        test(304);
        test(305);
    }
}
