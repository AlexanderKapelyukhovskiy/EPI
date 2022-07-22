package com.alkapa.epi.A_13_sorting;

import java.util.*;

public class A_13_09_PartitioningAndSortingAnArrayWithManyRepeatedEntries {
    private static class Person {
        public Integer age;
        public String name;
        public Person(String name, Integer age) {
            this.age = age;
            this.name = name;
        }
    }

    public static void groupByAge(List<Person> people) {
        Map<Integer, Integer> ageToCount = new HashMap<>();
        for (Person p : people) {
            ageToCount.put(p.age, ageToCount.getOrDefault(p.age, 0) + 1);
        }

        Map<Integer, Integer> ageToOffset = new HashMap<>();
        int offset = 0;
        for(Map.Entry<Integer, Integer> kc : ageToCount.entrySet()) {
            ageToOffset.put(kc.getKey(), offset);
            offset += kc.getValue();
        }

        while (!ageToOffset.isEmpty()) {
            Map.Entry<Integer, Integer> from = ageToOffset.entrySet().iterator().next();
            Integer toAge = people.get(from.getValue()).age;
            Integer toValue = ageToOffset.get(toAge);
            Collections.swap(people, from.getValue(), toValue);
            Integer count = ageToCount.get(toAge) - 1;
            ageToCount.put(toAge, count);
            if(count > 0) {
                ageToOffset.put(toAge, toValue + 1);
            } else {
                ageToOffset.remove(toAge);
            }
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Greg", 14));
        people.add(new Person("John", 12));
        people.add(new Person("Andy", 11));
        people.add(new Person("Jim", 13));
        people.add(new Person("Phil", 12));
        people.add(new Person("Bob", 13));
        people.add(new Person("Chip", 13));
        people.add(new Person("Tim", 14));

        groupByAge(people);

        for(Person p : people) {
            System.out.println(String.format("%d - %s", p.age, p.name));
        }
    }
}
