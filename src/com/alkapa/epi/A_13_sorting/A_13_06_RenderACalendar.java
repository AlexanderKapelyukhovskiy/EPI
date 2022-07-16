package com.alkapa.epi.A_13_sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class A_13_06_RenderACalendar {
    private static class Event {
        public int start, finish;

        public Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    private static class Endpoint {
        public int time;
        public boolean isStart;

        public Endpoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public static int findMaxSimultaneousEvents(List<Event> A) {
        List<Endpoint> E = A.stream()
                .map(event -> List.of(
                        new Endpoint(event.start, true),
                        new Endpoint(event.finish, false)))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        E.sort((a, b) -> {
            if (a.time != b.time) {
                return Integer.compare(a.time, b.time);
            }
            return a.isStart && !b.isStart ? -1 : !a.isStart && b.isStart ? 1 : 0;
        });

        int numSimultaneouslyEvents = 0, maxNumSimultaneouslyEvents = 0;
        for (Endpoint e : E) {
            if (e.isStart) {
                numSimultaneouslyEvents++;
                if (maxNumSimultaneouslyEvents < numSimultaneouslyEvents) {
                    maxNumSimultaneouslyEvents = numSimultaneouslyEvents;
                }
            } else {
                numSimultaneouslyEvents--;
            }
        }
        return maxNumSimultaneouslyEvents;
    }

    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, 5));
        events.add(new Event(6, 10));
        events.add(new Event(11, 13));
        events.add(new Event(14, 15));
        events.add(new Event(2, 7));
        events.add(new Event(8, 9));
        events.add(new Event(12, 15));
        events.add(new Event(4, 5));
        events.add(new Event(9, 17));

        System.out.println(findMaxSimultaneousEvents(events));
    }
}
