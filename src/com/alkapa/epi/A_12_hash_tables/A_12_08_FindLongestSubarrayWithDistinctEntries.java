package com.alkapa.epi.A_12_hash_tables;

import java.util.*;

public class A_12_08_FindLongestSubarrayWithDistinctEntries {
    public static int findLongestSubarrayWithDistinctEntriesV(List<String> A) {
        Map<String, Integer> map = new HashMap<>();
        int longest = 0, result =0;
        for(int i = 0; i < A.size(); ++i) {
            Integer dup = map.put(A.get(i), i);
            if (dup != null) {
                if (dup >= longest) {
                    result = Math.max(result, i - longest);
                    longest = dup + 1;
                }
            }
        }
        return Math.max(result, A.size() - longest);
    }


    public static void main(String[] args) {
        List<String> A = new ArrayList<>();
        A.add("f");
        A.add("s");
        A.add("f");
        A.add("e");
        A.add("t");
        A.add("w");
        A.add("e");
        A.add("n");
        A.add("w");
        A.add("e");

        System.out.println(findLongestSubarrayWithDistinctEntriesV(A));
    }
}
