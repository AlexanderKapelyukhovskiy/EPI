package com.alkapa.epi.A_15_recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A_15_01_TheTowersOfHanoiProblem {
    private static final int NUMBER_OF_PEGS = 3;

    public static List<List<Integer>> computeTowerHanoi(int numberRings) {
        List<Deque<Integer>> pegs = IntStream.range(0, NUMBER_OF_PEGS)
                .mapToObj(i -> new ArrayDeque<Integer>())
                .collect(Collectors.toList());

        for(int i = numberRings; i >= 1; --i) {
            pegs.get(0).add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        computeTowerHanoiSteps(numberRings, pegs, 0, 1, 2, result);
        return result;
    }
    private static void computeTowerHanoiSteps(
            int numRingsToMove, List<Deque<Integer>> pegs,
            int fromPeg, int toPer, int usePeg, List<List<Integer>> result) {
        if (numRingsToMove > 0) {
            computeTowerHanoiSteps(numRingsToMove -1, pegs, fromPeg, usePeg, toPer, result);
            pegs.get(toPer).addFirst(pegs.get(fromPeg).removeFirst());
            result.add(List.of(fromPeg, toPer));
            computeTowerHanoiSteps(numRingsToMove -1, pegs, usePeg, toPer, fromPeg, result);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = computeTowerHanoi(3);
        for(List<Integer> l : res) {
            System.out.print(String.format("<%d, %d>, ", l.get(0), l.get(1)));
        }
    }
}
