package com.alkapa.epi.A_15_recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_15_11_ComputeAGrayCode {
    public static List<Integer> greyCode(int numBits) {
        List<Integer> result = new ArrayList<>(List.of(0));
        directGreyCode(numBits, new HashSet<>(List.of()), result);
        return null;
    }

    private static boolean directGreyCode(int numBits, Set<Integer> history, List<Integer> result) {
        if (result.size() == (1 << numBits)) {
            return differsByOneBit(result.get(0), result.get(result.size() - 1));
        }
        for (int i = 0; i < numBits; ++i) {
            int previousCode = result.get(result.get(result.size() - 1));
            int candidateCode = previousCode ^ (1 << i);
            if (!history.contains(candidateCode)) {
                history.add(candidateCode);
                result.add(candidateCode);
                if (directGreyCode(numBits, history, result)) {
                    return true;
                }
                history.remove(candidateCode);
                result.remove(result.size() - 1);
            }
        }
        return false;
    }

    public static List<Integer> greyCode2(int numBits) {
        if (numBits == 0) {
            return new ArrayList<>(List.of(0));
        }
        List<Integer> presvGreyCodes = greyCode2(numBits - 1);
        int lendingBitOne = 1 << (numBits - 1);
        for (int i = presvGreyCodes.size() - 1; i >= 0; --i) {
            presvGreyCodes.add(lendingBitOne | presvGreyCodes.get(i));
        }
        return presvGreyCodes;
    }

    private static boolean differsByOneBit(int x, int y) {
        int bitDifference = x ^ y;
        return bitDifference != 0 && (bitDifference & (bitDifference - 1)) == 0;
    }

    public static void main(String[] args) {
        List<Integer> grayCode = greyCode2(2);
        for (Integer i : grayCode) {
            System.out.println(i);
        }
        System.out.println();
        grayCode = greyCode2(3);
        for (Integer i : grayCode) {
            System.out.println(i);
        }
    }
}
