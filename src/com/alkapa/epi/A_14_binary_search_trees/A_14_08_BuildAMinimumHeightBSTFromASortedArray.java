package com.alkapa.epi.A_14_binary_search_trees;

import com.alkapa.epi.A_09_trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class A_14_08_BuildAMinimumHeightBSTFromASortedArray {
    public static BinaryTreeNode<Integer> buildMinimumHeightBSTFromSortedArray(List<Integer> A) {
        return buildMinimumHeightBSTFromSortedSubArray(A, 0, A.size());
    }

    private static BinaryTreeNode<Integer> buildMinimumHeightBSTFromSortedSubArray(List<Integer> A, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = start + ((end - start) / 2);
        return new BinaryTreeNode<>(A.get(mid),
                buildMinimumHeightBSTFromSortedSubArray(A, start, mid),
                buildMinimumHeightBSTFromSortedSubArray(A, mid + 1, end));
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);
        A.add(9);
        BinaryTreeNode<Integer> BST = buildMinimumHeightBSTFromSortedArray(A);
    }
}

