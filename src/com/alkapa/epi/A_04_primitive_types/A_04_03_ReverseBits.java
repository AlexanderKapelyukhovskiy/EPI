package com.alkapa.epi.A_04_primitive_types;

public class A_04_03_ReverseBits {
    public static long reverse_brute_16(int x) {
        for (int i = 0; i < 8; i++) {
            if (((x >>> i) & 0x1) != ((x >>> 15 - i) & 0x1)) {
                int mask = 0x1 << i | 0x1 << 15 - i;
                x ^= mask;
            }
        }
        return x;
    }

    public static long[] precomputedReverse = null;
    public static long reverse(long x) {
        if (precomputedReverse == null) {
            precomputedReverse = new long[65536];
            for (int i = 0; i < precomputedReverse.length; i++) {
                precomputedReverse[i] = reverse_brute_16(i);
            }
        }
        int mask = 0xFFFF;
        int maskSize = 16;
        return precomputedReverse[(int) (x & mask)] << 3 * maskSize
                | precomputedReverse[(int) ((x >>> maskSize) & mask)] << 2 * maskSize
                | precomputedReverse[(int) ((x >>> 2 * maskSize) & mask)] << maskSize
                | precomputedReverse[(int) ((x >>> 3 * maskSize) & mask)];
    }

    public static void test(String bin) {
        long input = Long.parseLong(bin, 2);
        long res = reverse(input);
        System.out.println(Long.toBinaryString(res));
    }

    public static void main (String[] args) {
        test("0010001101");
        test("10101010101");
    }
}
