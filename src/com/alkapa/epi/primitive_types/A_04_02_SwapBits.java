package com.alkapa.epi.primitive_types;

public class A_04_02_SwapBits {
    public static long swapBits(long x, int i, int j) {
        if (((x >>> i) & 0x1) != ((x >>> j) & 0x1)) {
            long mask = 0x1 << i | 0x1<<j;
            return x ^ mask;
        }
        return x;
    }

    public static void test(String bin, int i, int j, String expected) {
        long val = Integer.parseInt(bin, 2);
        long swapped = swapBits(val, i, j);
        String swappedString = Long.toBinaryString(swapped);
        assert swappedString.equals(expected);
        System.out.println(String.format("%s -> %s", bin, swappedString));
    }

    public static void main(String[] args) {
        test("001", 2, 0, "100");
        test("101", 2, 0, "101" );
        test("0101", 3, 0, "1100" );
        test("111010101010", 8, 1, "111110101000" );
    }
}
