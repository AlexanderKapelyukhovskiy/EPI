package com.alkapa.epi.A_04_primitive_types;

/**
 * <h3>4.1 Computing the parity of a word</h3>
 * <p>
 * The parity of a binary word is 1 if the number of 1s in the word is odd (1,3,..); otherwise, it is 0.
 * For example, the parity of 10001000 is 0. Parity checks are used to detect single bit error in data
 * storage and communication.
 * </p>
 */
public class A_04_01_ParityOfTheWordSolution {

    /**
     * The brute-force algorithm iteratively test the values of each bit while tracking the number 1s seen so far.
     * Since we only care if the number of 1s is even (2,4,..) or odd (1,3,..), we can store the number mod 2.
     *
     * @param x sequence of words (4 words)
     * @return if this sequence of words has parity
     */
    public static boolean parityBruteForce(long x) {
        byte result = 0; // it could be only 0 or 1
        while (x != 0) {
            result ^= (x & 1); // check if LSB of x is 1 and toggle result for next bit
            x >>>= 1; // shift x for checking next LSB bit
        }
        return result == 1;
    }

    /**
     * Improved version of brute-force solution based on bit-fiddling trick x & (x-1) equals to x with
     * its lowest set bit erased.
     * <p>x = 00101100 -> x - 1 = 00101011 -> x & (x-1) = 00101100 & 00101011 = 00101000.</p>
     * Using this trick we can skip checking 0s between 1s.
     *
     * @param x sequence of words (4 words)
     * @return if this sequence of words has parity
     */
    public static boolean parityUsingBitFiddlingTrick(long x) {
        byte result = 0; // it could be only 0 or 1
        while (x != 0) {
            result ^= 1; // as we are checking only 1s we will toggle result for every 1s.
            x &= (x - 1); // erase the lowest set bit in x
        }
        return result == 1;
    }

    /**
     * Cached parities for every word (0-65536)
     */
    protected static boolean[] parityCache;

    /**
     * Initialization of Cached parities.
     * <p>it uses the quickest solution of parity to build the cache</p>
     */
    protected static void initParityCache() {
        parityCache = new boolean[(int) Math.pow(2, Short.BYTES * 8)];
        for (int i = 0; i <= parityCache.length - 1; i++) {
            parityCache[i] = parityUsingXorOfGroup(i);
        }
    }


    /**
     * Computation of parity for long sequence of words using cached values.
     * <p>To avoid too big cache we precompute parity only for one word (0-65536). After getting parity for every word
     * in sequence we can easily get overall parity for sequence with help of xor operation for every parity </p>
     * <p>P[n] = p[0] ^ p[1] ^ ... ^ p[n]</p>
     *
     * @param x sequence of words (4 words)
     * @return if this sequence of words has parity
     */
    public static boolean parityUsingCache(long x) {
        if (parityCache == null) {
            initParityCache();
        }

        int maskSize = 16;
        int mask = 0xFFFF;

        int firstMostSignificantWord = (int) (x >> (3 * maskSize)) & mask;
        int secondMostSignificantWord = (int) (x >> (2 * maskSize)) & mask;
        int thirdMostSignificantWord = (int) (x >> (1 * maskSize)) & mask;
        int fourthMostSignificantWord = (int) (x & mask);


        byte result = (byte) ((parityCache[firstMostSignificantWord] ? 1 : 0)
                ^ (parityCache[secondMostSignificantWord] ? 1 : 0)
                ^ (parityCache[thirdMostSignificantWord] ? 1 : 0)
                ^ (parityCache[fourthMostSignificantWord] ? 1 : 0));

        return result == 1;
    }

    /**
     * The most efficient log(n) solution for parity is based on fact that XOR of a group of bits is its parity.
     * <p>Parity of (b63, b62, ...,b1, b0) is parity of (b63, b62, ...,b32) XOR (b31, b32, ..., b0) </p>
     *
     * @param x sequence of words (4 words)
     * @return if this sequence of words has parity
     */
    public static boolean parityUsingXorOfGroup(long x) {
        // 1) (x) -> (b63, b62, ..., b0) XOR (x >>> 32) (0, 0, ..., 0, b63, b62, ..., b32)
        // [b31, b0] XOR [b63, b32] -> [b31, b0]
        x ^= x >>> 32; // XOR first and second part of bytes with saving result in second part of bytes
        // 2) x -> (xor1_63, xor1_62, ..., xor1_0) XOR (0, 0, ..., ..., xor1_16)
        // [b15, b0] XOR [b31, b16] -> [b15, b0]
        x ^= x >>> 16; // now skipping first part we continue doing XOR for parts of result of previous XOR in second part
        // 3) x -> (xor2_63, xor2_62, ..., xor2_0) XOR (0, 0, ..., xor2_8)
        // [b7, b0] XOR [b15, b8] -> [b7, b0]
        x ^= x >>> 8;
        // 4) x -> (xor3_63, xor3_62, ..., xor3_0) XOR (0, 0, ..., xor3_4)
        // [b3, b0] XOR [b7, b4] -> [b3, b0]
        x ^= x >>> 4;
        // 5) x -> (xor4_63, xor4_62, ..., xor4_0) XOR (0, 0, ..., xor4_2)
        // [b1, b0] XOR [b3, b2] -> [b1, b0]
        x ^= x >>> 2;
        // 6) x -> (xor5_63, xor5_62, ..., xor5_0) XOR (0, x5_63, ..., xor5_1)
        // [b1] XOR [b0] -> [b0]
        x ^= x >>> 1;
        byte result = (byte) (x & 0x1);
        return result == 1;
    }

    public interface IParity {
        boolean parity(long x);
    }

    public static void test(String bin, IParity parity, String v) {
        long x = Long.parseLong(bin, 2);
        long startTime = System.nanoTime();
        boolean isParity = parity.parity(x);
        long elapsedTime = System.nanoTime() - startTime;

        System.out.println(String.format("%s : %s - %b %d", v, bin, isParity, elapsedTime));
    }

    public static void main(String[] args) {
        // System.out.println(String.format("%d", parityBruteForce(Long.parseLong("00101010101", 2))));
        IParity p_1 = (long x) -> parityBruteForce(x);
        IParity p_2 = (long x) -> parityUsingBitFiddlingTrick(x);
        IParity p_3 = (long x) -> parityUsingCache(x);
        IParity p_4 = (long x) -> parityUsingXorOfGroup(x);

        String[] values = new String[]{
                "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "10111", "10001000", "10001001", "00101010101", "10101010101"};

        for (String v : values) {
            test(v, p_1, "parityBruteForce            ");
            test(v, p_2, "parityUsingBitFiddlingTrick ");
            test(v, p_3, "parityUsingCache            ");
            test(v, p_4, "parityUsingXorOfGroup       ");
            System.out.println();
        }
    }
}
