package com.alkapa.epi.A_12_hash_tables;

import java.util.*;

public class A_12_06_FindTheSmallestSubarrayCoveringAllValues {
    private static class Subarray {
        Integer start;
        Integer end;

        public Subarray(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }
    }

    public static Subarray findSmallestSubarrayCoveringSet(List<String> paragraph, Set<String> keywords) {
        HashMap<String, Subarray> map = new HashMap<>();

        for (int i = 0; i < paragraph.size(); ++i) {
            Subarray subarray = map.get(paragraph.get(i));
            if (subarray == null) {
                map.putIfAbsent(paragraph.get(i), new Subarray(i, i));
            } else {
                subarray.end = i;
            }
        }

        Subarray result = new Subarray(paragraph.size()-1, 0);
        for (String keyword : keywords) {
            Subarray subarray = map.get(keyword);
            if (subarray != null) {
                result.start = Math.min(result.start, subarray.start);
                result.end = Math.max(result.end, subarray.end);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> paragraph = new ArrayList<>();
        paragraph.add("1");
        paragraph.add("2");
        paragraph.add("3");
        paragraph.add("4");

        Set<String> keywords = new HashSet<>();
        keywords.add("2");
        keywords.add("3");

        Subarray res = findSmallestSubarrayCoveringSet(paragraph, keywords);
        System.out.println(String.format("%d %d", res.start, res.end));
    }
}
