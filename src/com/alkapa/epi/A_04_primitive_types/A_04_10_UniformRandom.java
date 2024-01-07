package com.alkapa.epi.A_04_primitive_types;

import java.util.Random;

/**
 * <h3>4.10 Generate Uniform Random Number</h3>
 * <p>
 * This problem is motivated by the following scenario. Six friends have to select a designated driver
 * using a single unbiased coin. The process should be fair to everyone.
 * </p>
 */
public class A_04_10_UniformRandom {
    /**
     * Returns Uniform Random Number in given interval calculated with help of random generator which produce 0 or 1.
     *
     * @param lowerBound lower bound of interval
     * @param upperBound upper bound of interval
     * @return random number within given interval
     */
    public static int uniformRandom(int lowerBound, int upperBound) {
        int numberOfOutcomes = upperBound - lowerBound + 1;
        int result;
        do {
            result = 0;
            //we are setting every bite of result with randomly selected 0 or 1 until we got 2^i >= numberOfOutcomes
            for (int i = 0; (1 << i) < numberOfOutcomes; i++) {
                result = (result << 1) | zeroOneRandom();
            }
        } while (result >= numberOfOutcomes); // if result bigger than numberOfOutcomes we repeat random number generation
        return result + lowerBound;
    }

    public static int zeroOneRandom() {
        return new Random().nextBoolean() ? 1 : 0;
    }

    private static float test(int lowerBound, int upperBound) {
        int res = uniformRandom(lowerBound, upperBound);
        if (res < lowerBound || res > upperBound) {
            System.out.print("Error: ");
        }
        float f = (float) res / (upperBound - lowerBound);
        System.out.println(String.format("[%d Random: %d %d] %f", lowerBound, res, upperBound, f));
        return f;
    }

    public static void main(String[] args) {
        int n = 0;
        float s = 0;
        for (int i = 1; i < 100000; i += 100) {
            n++;
            s += test(i, i * 100);
        }
        System.out.println(String.format("%d calls, Average %f", n, s/n));
    }
}
