package com.alkapa.epi.A_13_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_13_04_RemoveFirstNameDuplicates {
    private static class Name implements Comparable<Name> {
        String firstName;
        String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        @Override
        public int compareTo(Name o) {
            int comp = firstName.compareTo(o.firstName);
            if(comp != 0){
                return comp;
            }
            return lastName.compareTo(o.lastName);
        }
    }

    public static void eliminateDuplicate(List<Name> names) {
        Collections.sort(names);
        int writeIndex = 0;
        for (int i = 1; i < names.size(); ++i) {
            if (!names.get(i).firstName.equals(names.get(writeIndex).firstName)) {
                names.set(++writeIndex, names.get(i));
            }
        }
        names.subList(++writeIndex, names.size()).clear();
    }

    public static void main(String[] args) {
        List<Name> names = new ArrayList<>();
        names.add(new Name("Ian", "Botham"));
        names.add(new Name("David", "Gower"));
        names.add(new Name("Ian", "Bell"));
        names.add(new Name("Ian", "Chappell"));
        eliminateDuplicate(names);

        for(Name n : names) {
            System.out.println(String.format("%s %s", n.firstName, n.lastName));
        }
    }
}
