package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.3 Reverse Bits</h3>
 * <p>
 * Write a program that takes a 64-bit unsigned integer and return the 64-bit unsigned integer consisting of
 * the bits in reverse order. For example if the input is (111000000000001) output should be (100000000000111).
 * </p>
 */
public class A_04_03_ReverseBits {
    /**
     * Brute force implementation of reverse
     * @param x
     * @return reversed representation of x
     */
    public static int reverse16BitsUsingSwap(int x) {
        for (byte i = 0; i < 8; i++) {
            //shift x bits left i times and check first bit (first swap bit)
            byte firstBit = (byte) ((x >>> i) & 0x1);
            //shift x bits left 15 - i times and check first bit (last swap bit)
            byte lastBit = (byte) ((x >>> 15 - i) & 0x1);
            // swap only if bits are different
            if (firstBit != lastBit) {
                int firstBitMask = (0x1 << i);
                int lastBitMask = (0x1 << 15 - i);
                int swapMask = (firstBitMask | lastBitMask);
                x ^= swapMask;
            }
        }
        return x;
    }

    public static int[] precomputedReverse = null;

    /**
     * Calculate cache of reversed bits for first 16 bits
     */
    private static void initCache() {
        precomputedReverse = new int[(int) Math.pow(2, Short.BYTES * 8)];
        for (int i = 0; i < precomputedReverse.length; i++) {
            precomputedReverse[i] = reverse16BitsUsingSwap(i);
        }
    }

    /**
     * Reverse using cache
     *
     * @param x
     * @return reversed representation of x
     */
    public static long reverse(long x) {
        if (precomputedReverse == null) {
            initCache();
        }

        int mask = 0xFFFF;
        int maskSize = Short.BYTES * 8;
        return (long) precomputedReverse[(int) (x & mask)] << 3 * maskSize
                | (long) precomputedReverse[(int) ((x >>> maskSize) & mask)] << 2 * maskSize
                | (long) precomputedReverse[(int) ((x >>> 2 * maskSize) & mask)] << maskSize
                | (long) precomputedReverse[(int) ((x >>> 3 * maskSize) & mask)];
    }

    public static void test(String bin) {
        Long input = Long.parseLong(bin, 2);
        long startTime = System.nanoTime();
        Long res = reverse(input);
        long endTime = System.nanoTime();
        String s = Long.toBinaryString(res);
        String s1 = new StringBuilder(s).reverse().toString();

        System.out.println(String.format("input : %s", bin));
        System.out.println(String.format("result: %s", s));

        if (!s1.equals(bin)) {
            System.out.println("error");
        }

        System.out.println(String.format("took %d", endTime - startTime));
    }

    public static void main(String[] args) {
        test("0100000000000000000000000000000000000000000000000000000010001101");
        test("0000000000000000000000000000000000000000000000001000010101010101");
        test("0111111111111111111111111111111111011000100000000000000000000001");
        test("0000000000000000000000000000000000000000000000001000010101010101");

        test("0111111111111111111111111111111111111111111111110000000000000001");
        test("0111111111111111000001111000011000001111111111111000000000000011");
    }
}
