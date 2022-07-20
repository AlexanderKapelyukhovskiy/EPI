package com.alkapa.epi.A_13_sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class A_13_08_ComputeTheUnionOfIntervals {
    private static class Interval {
        public Endpoint left, right;

        public Interval(Endpoint left, Endpoint right) {
            this.left = left;
            this.right = right;
        }

        private static class Endpoint {
            public int val;
            public boolean isClosed;

            public Endpoint(int val, boolean isClosed) {
                this.val = val;
                this.isClosed = isClosed;
            }
        }
    }

    public static List<Interval> unionOfIntervals(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return Collections.emptyList();
        }

        intervals.sort((a, b) -> {
            if (a.left.val != b.right.val) {
                return Integer.compare(a.left.val, b.left.val);
            }
            return a.left.isClosed && !b.left.isClosed ? 1 : !a.left.isClosed && b.left.isClosed ? -1 : 0;
        });

        List<Interval> result = new ArrayList<>(List.of(intervals.get(0)));

        for(Interval i : intervals) {
            if (!result.isEmpty() &&
                    (i.left.val < result.get(result.size() - 1).right.val ||
                            (i.left.val == result.get(result.size() - 1).right.val &&
                                    (i.left.isClosed ||
                                            result.get(result.size() - 1).right.isClosed)))) {
                if (i.right.val > result.get(result.size() - 1).right.val ||
                        (i.right.val == result.get(result.size() - 1).right.val &&
                                i.right.isClosed)) {
                    result.get(result.size() - 1).right = i.right;
                }
            } else {
                result.add(i);
            }
        }

        return result;
    }

    
}
