package com.alkapa.epi.A_04_primitive_types;

public class A_04_05_ComputeProductWithoutArithmeticalOperation {
    public static long product(long x, long y) {
        long sum = 0;
        while (x != 0) {
            if ((x & 0x1) !=0) {
                sum = add(sum, y);
            }
            x >>>= 1;
            y <<= 1;
        }
        return sum;
    }
    public static long add(long a, long b){
        return b == 0 ? a : add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(product(13, 9));
        System.out.println(product(10, 9));
    }
}
