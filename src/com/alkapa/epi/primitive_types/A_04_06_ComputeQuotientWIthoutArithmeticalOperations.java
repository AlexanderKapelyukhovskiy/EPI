package com.alkapa.epi.primitive_types;

public class A_04_06_ComputeQuotientWIthoutArithmeticalOperations {
    public static int divide(int x, int y){
        int  result = 0;
        int power = 32;
        long yPower = (long)x << power;
        while(x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }
            result += 1 << power;
            x-=yPower;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(divide(100, 90));
    }
}
