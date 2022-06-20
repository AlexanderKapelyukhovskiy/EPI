package com.alkapa.epi.heaps;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A_10_04_ComputeTheKClosestStars {
    private static class Star implements Comparable<Star> {
        private int x, y, z;

        public Star(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double distance() {
            return Math.sqrt(x * x + y * y + z * z);
        }

        @Override
        public int compareTo(Star o) {
            return Double.compare(this.distance(), o.distance());
        }

        @Override
        public String toString() {
            return String.format("%d %d %d", x, y, z);
        }
    }

    public static List<Star> findClosestKStars(Iterator<Star> stars, int k) {
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < k && stars.hasNext(); ++i) {
            maxHeap.add(stars.next());
        }

        while (stars.hasNext()) {
            Star star = stars.next();
            if (maxHeap.peek().compareTo(star) > 0) {
                maxHeap.poll();
                maxHeap.add(star);
            }
        }
        return Stream.generate(maxHeap::poll).limit(maxHeap.size()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Star> stars = new ArrayList<>();
        stars.add(new Star(1, 1, 1));
        stars.add(new Star(5, 5, 5));
        stars.add(new Star(4, 4, 4));
        stars.add(new Star(7, 7, 7));
        stars.add(new Star(3, 3, 3));
        stars.add(new Star(2, 2, 2));

        List<Star> closest = findClosestKStars(stars.listIterator(), 3);
        for (Star s : closest) {
            System.out.println(s);
        }
    }
}
