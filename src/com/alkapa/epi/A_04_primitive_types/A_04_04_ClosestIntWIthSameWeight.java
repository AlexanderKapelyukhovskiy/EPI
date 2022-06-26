package com.alkapa.epi.A_04_primitive_types;

public class A_04_04_ClosestIntWIthSameWeight {
    static final int NUMBER_UNSIGNED_BITS = 63;

    public static long closestIntWithSameBitCount(long x) {
        if (x < 0)  {
            throw new IllegalArgumentException("Please provide positive int");
        }

        for (int i = 0; i < NUMBER_UNSIGNED_BITS - 1; i++) {
            if (((x >>> i) & 0x1) != ((x >>> (i + 1)) & 0x1)) { // check that neighbour bits are different
                return x ^ (0x1 << i) | (0x1 << (i + 1)); // swap neighbour bits
            }
        }

        throw new IllegalArgumentException("all bits set to 1");
    }

    public static void test(String bin) {
        long val = Long.parseLong(bin, 2);
        long res = closestIntWithSameBitCount(val);
        System.out.println(String.format("%s - %s", bin, Long.toBinaryString(res)));
    }

    public static void main(String[] args) {
        test("00101");
        test("0011");
    }
}
