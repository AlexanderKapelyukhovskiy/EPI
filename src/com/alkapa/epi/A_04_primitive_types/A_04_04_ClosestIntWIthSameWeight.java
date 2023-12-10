package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.4 Find a closest integer with the same weight</h3>
 * <p>
 * Define the weight of a nonnegative integer x to be the number of bits that are set to 1 in binary representation.
 * For example, since 92 in base-2 equals (1011100), the weight of 92 is 4.
 * </p>
 * <p>
 * Write a program which takes as input a nonnegative integer x and returns a number y which is not equal to x,
 * but has same weight as x and their difference, |y-x|, is as small as possible. You can assume x is not 0, or all 1s.
 * For example if x = 6, you should return 5.
 * </p>
 */
public class A_04_04_ClosestIntWIthSameWeight {
    static final int NUMBER_UNSIGNED_BITS = 63;

    /**
     * Returns closes int with same weight
     * @param x nonnegative integer >0 and not all 1s
     * @return closest integer with same weight
     */
    public static long closestIntWithSameBitCount(long x) {
        if (x < 0) {
            throw new IllegalArgumentException("Please provide positive int");
        }

        for (int i = 0; i < NUMBER_UNSIGNED_BITS - 1; i++) {
            byte currentBit = (byte)((x >>> i) & 0x1);
            byte nextBit = (byte)((x >>> (i + 1)) & 0x1);

            if (currentBit != nextBit) { // check that neighbour bits are different
                long currentBitMask = (0x1 << i);
                long nextBitMask = (0x1 << (i + 1));
                long swapBitsMask = currentBitMask | nextBitMask;
                return x ^ swapBitsMask; // swap neighbour bits
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
