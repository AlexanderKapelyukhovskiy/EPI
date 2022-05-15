package com.alkapa.epi.primitive_types;

public class A_04_01_ParityOfTheWordSolution {
    public static short parity_1(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);//check LSB of 1
            x >>>= 1;
        }
        return result;
    }

    public static short parity_2(long x) {
        short result = 0;
        while(x != 0){
            result ^= 1;
            x &= (x-1); // drop the lowest set bit of x
        }
        return result;
    }

    public static boolean[] precomputedParity; //= new int[65536];


    public static short parity_3(long x) {
        if (precomputedParity ==null) {
            precomputedParity = new boolean[65536];
            for (int i = 0; i <= precomputedParity.length-1; i++) {
                precomputedParity[i] = parity_4(i) == 1;
            }
        }

        int maskSize = 16;
        int mask = 0xFFFF;

        return (short)((precomputedParity[(int) ((x >> (3 * maskSize)) & mask)] ? 1 : 0)
                ^ (precomputedParity[(int) ((x >> (2 * maskSize)) & mask)] ? 1 : 0)
                ^ (precomputedParity[(int) ((x >> (1 * maskSize)) & mask)] ? 1 : 0)
                ^ (precomputedParity[(int) (x  & mask)] ? 1 : 0));

    }

    public static short parity_4(long x) {
        x ^= x >>> 32; // XOR first and second part of bytes in word
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);
    }

    public interface IParity {
        short parity(long x);
    }

    public static void test(String bin, IParity parity, String v) {
        long val = Integer.parseInt(bin, 2);
        short parityValue = parity.parity(val);

        System.out.println(String.format("%s : %s - %o", v, bin, parityValue));
    }

    public static void main(String[] args) {
        IParity p_1 = (long x) -> parity_1(x);
        IParity p_2 = (long x) -> parity_2(x);
        IParity p_3 = (long x) -> parity_3(x);
        IParity p_4 = (long x) -> parity_4(x);

        String[] values = new String[] {
                "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111",
                "10111", "10001000", "10001001", "00101010101", "10101010101"};

        for (String v : values) {
            test(v, p_1, "parity_1");
            test(v, p_2, "parity_2");
            test(v, p_3, "parity_3");
            test(v, p_4, "parity_4");
            System.out.println();
        }
    }
}
