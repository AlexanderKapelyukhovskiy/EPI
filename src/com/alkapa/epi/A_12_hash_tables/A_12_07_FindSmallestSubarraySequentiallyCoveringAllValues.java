package com.alkapa.epi.A_12_hash_tables;

import java.util.*;

public class A_12_07_FindSmallestSubarraySequentiallyCoveringAllValues {
    private static class Subarray {
        Integer start;
        Integer end;

        public Subarray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Subarray findSmallestSequentiallyCoveringSubset(List<String> paragraph, List<String> keywords) {
        Map<String, Integer> keywordToIdx = new HashMap<>();
        List<Integer> lastOccurrence = new ArrayList<>(keywords.size());

        List<Integer> shortestSubarrayLength = new ArrayList<>(keywords.size());

        for(int i = 0; i < keywords.size(); ++i) {
            lastOccurrence.add(-1);
            shortestSubarrayLength.add(Integer.MAX_VALUE);
            keywordToIdx.put(keywords.get(i), i);
        }

        int shortestDistance = Integer.MAX_VALUE;
        Subarray result = new Subarray(-1, -1);

        for(int i = 0; i < paragraph.size(); ++i) {
            Integer keywordIdx = keywordToIdx.get(paragraph.get(i));
            if (keywordIdx != null) {
                if (keywordIdx == 0) {
                    shortestSubarrayLength.set(0, 1);
                } else if (shortestSubarrayLength.get(keywordIdx - 1) != Integer.MAX_VALUE) {
                    int distanceToPreviousKeyword = i - lastOccurrence.get(keywordIdx - 1);
                    shortestSubarrayLength.set(keywordIdx, distanceToPreviousKeyword + shortestSubarrayLength.get(keywordIdx - 1));
                }
                lastOccurrence.set(keywordIdx, i);

                if (keywordIdx == keywords.size() - 1
                        && shortestSubarrayLength.get(shortestSubarrayLength.size() - 1) < shortestDistance) {
                    shortestDistance = shortestSubarrayLength.get(shortestSubarrayLength.size() - 1);
                    result.start = i - shortestSubarrayLength.get(shortestSubarrayLength.size() - 1) + 1;
                    result.end = i;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> paragraph = new ArrayList<>();
        paragraph.add("apple");
        paragraph.add("banana");
        paragraph.add("banana");
        paragraph.add("apple");
        paragraph.add("apple");
        paragraph.add("dog");
        paragraph.add("cat");
        paragraph.add("apple");
        paragraph.add("dog");
        paragraph.add("banana");
        paragraph.add("apple");
        paragraph.add("cat");
        paragraph.add("dog");

        List<String> keywords = new ArrayList<>();
        keywords.add("banana");
        keywords.add("cat");

        Subarray res = findSmallestSequentiallyCoveringSubset(paragraph, keywords);
        System.out.println(String.format("%d %d", res.start, res.end));
    }
}
