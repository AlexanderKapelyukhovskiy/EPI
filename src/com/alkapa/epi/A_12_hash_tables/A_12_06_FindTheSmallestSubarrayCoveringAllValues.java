package com.alkapa.epi.A_12_hash_tables;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    public static Subarray findSmallestSubarrayCoveringSetV2(List<String> paragraph, Set<String> keywords) {
        Map<String, Long> keywordsToCover = keywords.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Subarray result = new Subarray(-1, -1);
        int remainingToCover = keywords.size();
        for(int left = 0, right = 0; right < paragraph.size(); ++ right) {

            if (keywordsToCover.containsKey(paragraph.get(right))
                    && keywordsToCover.put(paragraph.get(right), keywordsToCover.get(paragraph.get(right)) - 1) >= 1) {
                --remainingToCover;
            }

            while(remainingToCover == 0) {
                if ((result.start == -1 && result.end == -1)
                    || right - left < result.end - result.start) {
                    result.start = left;
                    result.end = right;
                }
                if (keywordsToCover.containsKey(paragraph.get(left))
                        && keywordsToCover.put(paragraph.get(left), keywordsToCover.get(left) + 1) >= 0)
                {
                    ++remainingToCover;
                }
                ++left;
            }
        }

        return result;
    }

    private static Integer getValueFroFirstEntry(LinkedHashMap<String, Integer> m) {
        Integer result = null;
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            result = entry.getValue();
            break;
        }
        return result;
    }

    public static Subarray findSmallestSubarrayCoveringSetV3(Iterator<String> paragraph, Set<String> keywords) {
        LinkedHashMap<String, Integer> dict = new LinkedHashMap<>(keywords.size(), 1, true);
        for(String s : keywords) {
            dict.put(s, null);
        }
        int numStringsFromQueryStringsSeenSoFar = 0;

        Subarray result = new Subarray(-1, -1);
        int idx = 0;
        while (paragraph.hasNext()) {
            String s  = paragraph.next();
            if (dict.containsKey(s)) {
                Integer it = dict.get(s);
                if (it == null) {
                    numStringsFromQueryStringsSeenSoFar++;
                }
                dict.put(s, idx);

                if (numStringsFromQueryStringsSeenSoFar == keywords.size()) {
                    if ((result.start == -1 && result.end == -1)
                        || idx - getValueFroFirstEntry(dict) < result.end - result.start) {
                        result.start = getValueFroFirstEntry(dict);
                        result.end = idx;
                    }
                }
            }
            ++idx;
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> paragraph = new ArrayList<>();
        paragraph.add("apple");
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

        Set<String> keywords = new HashSet<>();
        keywords.add("banana");
        keywords.add("cat");

        Subarray res = findSmallestSubarrayCoveringSetV3(paragraph.iterator(), keywords);
        System.out.println(String.format("%d %d", res.start, res.end));
    }
}
