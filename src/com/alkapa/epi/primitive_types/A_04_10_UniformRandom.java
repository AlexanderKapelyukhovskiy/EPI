package com.alkapa.epi.primitive_types;

import java.util.Random;

public class A_04_10_UniformRandom {
    public static int uniformRandom(int lowerBound, int upperBound) {
        int numberOfOutcomes = upperBound - lowerBound + 1;
        int result;
        do {
            result = 0;
            for (int i = 0; (1 << i) < numberOfOutcomes; i++) {
                result = (result << 1) | zeroOneRandom();
            }
        } while (result >= numberOfOutcomes);
        return result + lowerBound;
    }

    public static int zeroOneRandom() {
        return new Random().nextBoolean() ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(uniformRandom(1, 10));
    }
}
