package com.alkapa.epi.primitive_types;

public class A_04_07_ComputePow {
    public static double power(double x, int y) {
        double result = 1;
        long power = y;
        if (y < 0) {
            power *= -1;
            x = 1 / x;
        }
        while (power != 0) {
            if ((power & 0x1) !=0 ){
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(power(3,3));
    }
}
