package com.alkapa.epi.strings;

public class A_06_06_ReverseAllWordsInSentence {
    public static void reverseWords(char[] input) {
        int length = input.length;
        reverse(input, 0, length - 1);

        int start = 0, finish = 0;
        while (start < length) {
            while (start < finish || start < length && !Character.isAlphabetic(input[start])) {
                start++;
            }

            while (finish < start || finish < length && Character.isAlphabetic(input[finish])) {
                finish++;
            }
            reverse(input, start, finish - 1);
        }
//        for(int i = 0, j = 0; i < input.length; ++i) {
//            if (!Character.isAlphabetic(input[i])) {
//                reverse(input, j, i - 1);
//                j = i + 1;
//            }
//        }
    }

    public static void reverse(char[] input, int left, int right) {
        while (left < right) {

            char temp = input[left];
            input[left++] = input[right];
            input[right++] = temp;
        }
    }

    public static void test(char[] input) {
        for (char c : input) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        char[] input = new char[]{'I', ' ', ' ', ' ', ' ', 'l', 'o', 'v', 'e', ' ', ' ', 'y', 'o', 'u', ' ', 'a', 'l', 'l'};
        reverseWords(input);
        test(input);

        System.out.println("-----------------------");

        input = new char[]{'I', ' ', ' ', ' ', ' ', 'l', 'o', 'v', 'e', ' ', ' ', 'y', 'o', 'u'};
        reverseWords(input);
        test(input);
    }
}
