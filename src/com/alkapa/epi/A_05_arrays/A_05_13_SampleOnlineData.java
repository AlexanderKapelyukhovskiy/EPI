package com.alkapa.epi.A_05_arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class A_05_13_SampleOnlineData {
    public static List<Integer> onlineSampleData(Iterator<Integer> stream, int k) {
        List<Integer> runningSamples = new ArrayList<>(2);

        for (int i = 0; stream.hasNext() && i < k; ++i) {
            runningSamples.add(stream.next());
        }

        Random randIdxGen = new Random();
        int numberSeenSoFar = k;

        while (stream.hasNext()) {
            Integer x = stream.next();
            ++numberSeenSoFar;

            final int idxToReplace = randIdxGen.nextInt(numberSeenSoFar);
            if (idxToReplace < k) {
                runningSamples.set(idxToReplace, x);
            }
        }
        return runningSamples;
    }

    public static void main(String[] args) {
        List<Integer> stream = new ArrayList<>();
        stream.add(1);
        stream.add(2);
        stream.add(3);
        stream.add(4);
        stream.add(5);

        List<Integer> samples = onlineSampleData(stream.listIterator(), 3);
        for (int i : samples) {
            System.out.println(i);
        }
    }
}
