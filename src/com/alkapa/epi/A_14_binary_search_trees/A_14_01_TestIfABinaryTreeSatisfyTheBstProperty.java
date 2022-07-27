package com.alkapa.epi.A_14_binary_search_trees;

import com.alkapa.epi.A_09_trees.BinaryTreeNode;

public class A_14_01_TestIfABinaryTreeSatisfyTheBstProperty {
    public static boolean isBinaryTreeBst(BinaryTreeNode<Integer> tree) {
        return areKeysInRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean areKeysInRange(BinaryTreeNode<Integer> tree, Integer lower, Integer higher) {
        if (tree == null) {
            return true;
        }
        if (tree.data < lower || tree.data > higher) {
            return false;
        }
        return areKeysInRange(tree.left, lower, tree.data) && areKeysInRange(tree.right, tree.data, higher);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> bstTree
                = new BinaryTreeNode<>(5,
                new BinaryTreeNode<>(3,
                        new BinaryTreeNode<>(1, null, null),
                        new BinaryTreeNode<>(4, null, null)),
                new BinaryTreeNode<>(7,
                        new BinaryTreeNode<>(6, null, null),
                        new BinaryTreeNode<>(8, null, null)));

        System.out.println(isBinaryTreeBst(bstTree));

        BinaryTreeNode<Integer> notBstTree
                = new BinaryTreeNode<>(5,
                new BinaryTreeNode<>(3,
                        new BinaryTreeNode<>(1, null, null),
                        new BinaryTreeNode<>(9, null, null)),
                new BinaryTreeNode<>(7,
                        new BinaryTreeNode<>(6, null, null),
                        new BinaryTreeNode<>(8, null, null)));

        System.out.println(isBinaryTreeBst(notBstTree));
    }
}
