package com.alkapa.epi.strings;

public class A_06_04_ReplaceAndRemove {
    public static int replaceAndRemove(int size, char[] input) {
        int writeIdx = 0;
        int aCount = 0;
        for(int i = 0; i < size; ++i){
            if (input[i] != 'b') {
                input[writeIdx++] = input[i];
            }

            if (input[i] == 'a') {
                aCount++;
            }
        }
        writeIdx -= 1;
        int newSize = writeIdx + aCount;

        for (int i = writeIdx, j = writeIdx; i >= 0 && j < input.length; --i) {
            if (input[i] == 'a') {
                input[i] = 'd';
                input[++j] = 'd';
            }
        }

        return newSize;
    }

    public static int replaceAndRemoveV2(int size, char[] input) {
        int writeIdx = 0;
        int aCount = 0;
        for(int i = 0; i < size; ++i){
            if (input[i] != 'b') {
                input[writeIdx++] = input[i];
            }

            if (input[i] == 'a') {
                aCount++;
            }
        }
        writeIdx = writeIdx > 0 ? writeIdx - 1 : 0;

        int newSize = writeIdx + aCount;
        int curIdx = writeIdx;
        writeIdx = newSize;
        while(curIdx >= 0) {
            if(input[curIdx] == 'a') {
                input[writeIdx--] = 'd';
                input[writeIdx--] = 'd';
            } else {
                input[writeIdx--] = input[curIdx];
            }
            curIdx--;
        }

        return newSize;
    }

    public static void main(String[] args) {
        char[] input = new char[] {'a', 'c', 'd', 'b', 'b', 'c', 'a'};
        int size = replaceAndRemoveV2(input.length, input);
        for (int i = 0; i < size; ++i) {
            System.out.println(input[i]);
        }
    }
}
