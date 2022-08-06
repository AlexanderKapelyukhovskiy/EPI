package com.alkapa.epi.A_14_binary_search_trees;

import com.alkapa.epi.A_09_trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class A_14_10_TheRangeLookupProblem {
    private static class Interval {
        public int left, right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> rangeLookupInBST(BinaryTreeNode<Integer> tree, Interval interval) {
        List<Integer> result = new ArrayList<>();
        rangeLookupInBSTHelper(tree, interval, result);
        return result;
    }

    private static void rangeLookupInBSTHelper(BinaryTreeNode<Integer> tree, Interval interval, List<Integer> result) {
        if (tree == null) {
            return;
        }
        if (tree.data > interval.left && tree.data <= interval.right) {
            result.add(tree.data);
        }

        if (tree.left != null && tree.data > interval.left) {
            rangeLookupInBSTHelper(tree.left, interval, result);
        }

        if (tree.right != null && tree.data < interval.right) {
            rangeLookupInBSTHelper(tree.right, interval, result);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> bst = BinaryTreeNode.createBSTTree();
        List<Integer> res = rangeLookupInBST(bst, new Interval(16, 31));
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
