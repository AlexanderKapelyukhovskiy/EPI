package com.alkapa.epi.A_15_recursion;

import java.util.ArrayList;
import java.util.List;

public class A_15_02_ComputeAllMnemonicsForAPhoneNumber {
    public static List<String> computeMnemonic(String number) {
        List<String> result = new ArrayList<>();
        computeMnemonicHelper(number, 0, new char[number.length()], result);
        return result;
    }
    private static final String[] MAPPING = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
    private static void computeMnemonicHelper(String number, int digit, char[] partialMnemonic, List<String> result) {
        if (digit == number.length()) {
            result.add(new String(partialMnemonic));
            return;
        }
        String mnemonics = MAPPING[number.charAt(digit)- '0'];

        for(int i = 0; i< mnemonics.length(); ++i) {
            partialMnemonic[digit] = mnemonics.charAt(i);
            computeMnemonicHelper(number, digit + 1, partialMnemonic, result);
        }
    }

    public static void main(String[] args) {
        List<String> list = computeMnemonic("0134");
        for(String s : list) {
            System.out.println(s);
        }
    }
}