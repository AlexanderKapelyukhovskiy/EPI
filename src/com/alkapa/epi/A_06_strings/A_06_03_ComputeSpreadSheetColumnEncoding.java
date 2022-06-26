package com.alkapa.epi.A_06_strings;

public class A_06_03_ComputeSpreadSheetColumnEncoding {
    public static int encode(String numAsString) {
        return numAsString.chars().reduce(0, (x, c) -> x * 26 + c - 'A' + 1);
    }

    public static void main(String[] args) {
        System.out.println(encode("A"));
        System.out.println(encode("B"));
        System.out.println(encode("AA"));
        System.out.println(encode("AB"));
    }
}

