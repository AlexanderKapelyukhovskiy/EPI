package com.alkapa.epi.A_13_sorting;

import java.util.ArrayList;
import java.util.List;

public class A_13_07_MergingIntervals {
    private static class Interval {
        int begin, end;
        public Interval(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    public static List<Interval> addInterval(List<Interval> disjointIntervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();

        Interval union = null;

        for (int i = 0; i < disjointIntervals.size(); ++i) {
            Interval c = disjointIntervals.get(i);
            if (c.end < newInterval.begin) {
                result.add(c);
            } else if (c.begin < newInterval.begin || newInterval.end > c.begin ) {
                if (union == null) {
                    union = new Interval(c.begin, c.end);
                    result.add(union);
                } else {
                    union.end = c.end;
                }
            } else {
                result.add(c);
            }
        }

        return result;
    }

    public static void main (String[] args) {
        List<Interval> disjointIntervals = new ArrayList<>();
        disjointIntervals.add(new Interval(-4, -1));
        disjointIntervals.add(new Interval(0, 2));
        disjointIntervals.add(new Interval(3, 6));
        disjointIntervals.add(new Interval(7, 9));
        disjointIntervals.add(new Interval(11, 12));
        disjointIntervals.add(new Interval(14, 17));

        List<Interval> result = addInterval(disjointIntervals, new Interval(1, 8));
        for(Interval i : result) {
            System.out.println(String.format("[%d, %d]", i.begin, i.end));
        }
    }
}
