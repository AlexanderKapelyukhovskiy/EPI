package com.alkapa.epi.A_12_hash_tables;

import java.util.HashSet;
import java.util.Set;

public class A_12_11_TestCollatzConjecture {
    public static boolean testCollatzConjecture(int n) {
        Set<Long> verifiedNumbers = new HashSet<>();
        for(int i = 3; i <= n; i +=2) {
            Set<Long> sequence = new HashSet<>();
            long testI = i;
            while (testI  >= i) {
                if (!sequence.add(testI)) {
                    return false;
                }

                if ((testI % 2) != 0) {
                    if (!verifiedNumbers.add(testI)) {
                        break;
                    }
                    long nextTestI = 3 * testI + 1;
                    if (nextTestI <= testI) {
                        throw new ArithmeticException("overflow for " + i);
                    }
                    testI = nextTestI;
                } else {
                    testI /= 2;
                }
            }

        }
        return true;
    }
}
