package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.2 Swap bits</h3>
 * <p>
 * A 64-bit integer can be viewed as an array of 64 bits, with the bit at index 0 corresponding to the
 * least significant bit (LSB), and the bit at index 63 corresponding to the most significant bit (MSB).
 * Implement code that takes as input 64-bit integer and swaps the bits at indices i and j.
 * </p>
 * <p>i=1, j=6</p>
 * <p>0 <b>1</b> 0 0 1 0 <b>0</b> 1</p>
 * <p>0 <b>0</b> 0 0 1 0 <b>1</b> 1</p>
 */
public class A_04_02_SwapBits {
    /**
     * Swap bits in positions i in j of x
     *
     * @param x arrays of 64-bits
     * @param i first position of bit to swap
     * @param j second position of bit to swap
     * @return array of 64-bits from x with swapped bites in positions i and j
     */
    public static long swapBits(long x, int i, int j) {
        // check bits in position i
        boolean bitInI = ((x >>> i) & 0x1) == 0x1;
        // check bits in position j
        boolean bitInJ = ((x >>> j) & 0x1) == 0x1;
        // swap only bits only if bits in i and j positions are different
        if (bitInI != bitInJ) {
            long bitInIMask = 0x1 << i;
            long bitInJMask = 0x1 << j;

            // create mask for bits in positions i and j
            long mask = bitInIMask | bitInJMask;

            // XOR x with mask to swap bits in positions i and j
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
        test("101", 2, 0, "101");
        test("0101", 3, 0, "1100");
        test("111010101010", 8, 1, "111110101000");
    }
}
