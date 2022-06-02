package com.alkapa.epi.stacks_queues;

import com.alkapa.epi.linked_lists.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class A_08_05_ComputeBuildingWithSunsetView {
    public static List<Integer> examineBuildingsWithSunset(Iterator<Integer> sequence) {
        Deque<Integer> candidates = new ArrayDeque<>();

        while (sequence.hasNext()) {
            Integer buildIngHeight = sequence.next();
            while (!candidates.isEmpty() && buildIngHeight >= candidates.peek()) {
                candidates.pop();
            }

            candidates.push(buildIngHeight);
        }

        return candidates.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> buildings = new ArrayList();
        buildings.add(1);
        buildings.add(2);
        buildings.add(3);
        buildings.add(4);
        buildings.add(5);

        Collections.reverse(buildings);

        List<Integer> candidates = examineBuildingsWithSunset( buildings.listIterator());

        for (Integer c : candidates) {
            System.out.println(c);
        }

    }

}
