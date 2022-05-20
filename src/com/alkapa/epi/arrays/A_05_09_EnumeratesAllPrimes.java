package com.alkapa.epi.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_05_09_EnumeratesAllPrimes {
    public static List<Integer> generatePrimes(int n) {
        if (n < 2) {
            return Collections.emptyList();
        }
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, true);

        List<Integer> primes = new ArrayList<>();

        for (int p = 2;  p <= n; ++p) {
            if (isPrime.get(p)) {
                primes.add(p);
                for(int i = p * 2; i < n; i += p) {
                    isPrime.set(i, false);
                }
            }
        }
        return primes;
    }

    public static List<Integer> generatePrimesV2(int n) {
        if (n < 2) {
            return Collections.emptyList();
        }
        final int size = (int)Math.floor(0.5 * (n-3));

        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));

        List<Integer> primes = new ArrayList<>();

        for(long i = 0; i < size; ++i) {
            if (isPrime.get((int) i)) {
                int p = (((int)i*2) + 3);
                primes.add(p);
                for(long j = ((i * i) * 2) + 6*i + 3; j < size; j += p) {
                    isPrime.set((int)j, false);
                }
            }
        }
        return primes;
    }
}
