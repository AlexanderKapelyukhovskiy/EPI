package com.alkapa.epi.strings;

public class A_06_02_BaseConversion {
    public static String convertBase(String numberAsString, int b1, int b2) {
        boolean isNegative = numberAsString.startsWith("-");

        int numASInt = numberAsString.substring(isNegative? 1 : 0)
                .chars()
                .reduce(0, (x ,c) -> {
                        System.out.println( x + " - " + (char)c);
                        return x * b1 + (Character.isDigit(c) ? c - '0' : c - 'A' + 10);
                    }
                );


        return isNegative ? "-" : "" +(numASInt == 0 ? "0" : constructFromBase(numASInt, b2));
    }

    public static String constructFromBase(int numAsInt, int base) {
        System.out.println(numAsInt + " " + base);

        String s = numAsInt == 0 ? "" : constructFromBase(numAsInt / base, base)
                + (char)(numAsInt % base >= 10 ? 'A' + numAsInt % base - 10 : '0' + numAsInt % base);

        System.out.println(numAsInt + " " + base + " = " + s);

        return s;
    }

    public static void main(String[] args) {
        System.out.println(convertBase("615", 7, 13));
    }
}
