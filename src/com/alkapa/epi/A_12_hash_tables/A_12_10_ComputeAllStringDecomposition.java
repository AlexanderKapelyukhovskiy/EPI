package com.alkapa.epi.A_12_hash_tables;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A_12_10_ComputeAllStringDecomposition {
    public static List<Integer> findAllSubstrings(String s, List<String> words) {
        Map<String, Long> wordsToFreq = words.stream().collect(
                Collectors.groupingBy(Function.identity(),Collectors.counting()));

        int unitSize = words.get(0).length();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i + unitSize * words.size() <= s.length(); ++i) {
            if (matchAllWordsInDict(s, wordsToFreq, i, words.size(), unitSize)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean matchAllWordsInDict(
            String s, Map<String, Long> wordsToFreq, int start, int numberOfWords, int unitSize) {
        Map<String, Integer> currentStringFreq = new HashMap<>();
        for (int i = 0; i < numberOfWords;  ++i) {
            String currentWord = s.substring(start + i * unitSize, start + (i + 1) * unitSize);
            Long freq = wordsToFreq.get(currentWord);
            if (freq == null) {
                return false;
            }
            currentStringFreq.put(currentWord, currentStringFreq.getOrDefault(currentWord, 0) + 1);
            if ( currentStringFreq.get(currentWord) > freq) {
                return false;
            }
        }
        return true;
    }
}
