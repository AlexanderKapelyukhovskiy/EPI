package com.alkapa.epi.A_12_hash_tables;

import java.util.*;

public class A_12_05_FindTheNearestRepeatedEntriesInAnArray {
    public static int findNearestRepetition(List<String> paragraph) {
        Integer minPos = Integer.MAX_VALUE;
        HashMap<String, Integer> words = new HashMap<>();
        for (int i = 0; i < paragraph.size(); ++i) {
            Integer pos = words.get(paragraph.get(i));
            if (pos != null) {
                minPos = Math.min(minPos, i - pos);
            }
            words.put(paragraph.get(i), i);
        }
        return minPos == Integer.MAX_VALUE ? -1 : minPos;
    }

    public static void main(String[] args) {
        List<String> paragraph = Arrays.stream("All work and no play makes for no work no fun and no result".split(" ")).toList();
        System.out.println(findNearestRepetition(paragraph));
    }
}
