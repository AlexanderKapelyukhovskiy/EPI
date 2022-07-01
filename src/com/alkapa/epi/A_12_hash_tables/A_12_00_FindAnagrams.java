package com.alkapa.epi.A_12_hash_tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A_12_00_FindAnagrams {
    public static List<List<String>> findAnagrams(List<String> dictionary) {
        Map<String, List<String>> sortedStringToAnagrams = new HashMap<>();

        for(String s : dictionary) {
            String sorted = Stream.of(s.split("")).sorted().collect(Collectors.joining());
            sortedStringToAnagrams.putIfAbsent(sorted, new ArrayList<>());
            sortedStringToAnagrams.get(sorted).add(s);
        }
        return sortedStringToAnagrams.values()
                .stream()
                .filter(g -> g.size() >= 2)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("debit card");
        dictionary.add("elvis");
        dictionary.add("silent");
        dictionary.add("bad credit");
        dictionary.add("lives");
        dictionary.add("freedom");
        dictionary.add("listen");
        dictionary.add("levis");
        dictionary.add("money");

        List<List<String>> groups = findAnagrams(dictionary);
        for (List<String> g : groups) {
            for (String s : g) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
