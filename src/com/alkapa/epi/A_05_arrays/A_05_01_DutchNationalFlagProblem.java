package com.alkapa.epi.A_05_arrays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_05_01_DutchNationalFlagProblem {

    public enum Color {RED, WHITE, BLUE};

    public static void dutchFlagPartition1(int pivotIndex, List<Color> list) {
        Color pivot = list.get(pivotIndex);
        int smaller = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ordinal() < pivot.ordinal()){
                Collections.swap(list, smaller++, i);
            }
        }
        int larger = list.size() - 1;
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i).ordinal() > pivot.ordinal()){
                Collections.swap(list, larger--, i);
            }
        }
    }

    public static void dutchFlagPartition(int pivotIndex, List<Color> list) {
        Color pivot = list.get(pivotIndex);

        int smaller = 0, equal = 0, larger = list.size();

        while (equal < larger) {
            if (list.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(list, smaller++, equal++);
            } else if (list.get(equal).ordinal() == pivot.ordinal()) {
                ++equal;
            } else {
                Collections.swap(list, equal, --larger);
            }
        }
    }

    public static void partition(int partitionIndex, List<Color> list) {
        Color pivot = list.get(partitionIndex);

        int smaller = 0, equal = 0, larger = list.size();

        while (equal < larger) {
            if (list.get(equal).ordinal() < pivot.ordinal()){
                Collections.swap(list, smaller++, equal++);
            } else if (list.get(equal).ordinal() == pivot.ordinal()) {
                ++equal;
            } else {
                Collections.swap(list, equal, --larger);
            }
        }
    }



    public static void main(String[] args) {
        List<Color> list = new ArrayList<>();
        list.add(Color.BLUE);
        list.add(Color.RED);
        list.add(Color.WHITE);
        list.add(Color.BLUE);
        list.add(Color.RED);
        list.add(Color.RED);
        list.add(Color.RED);
        list.add(Color.WHITE);

        partition(2, list);
    }

}
