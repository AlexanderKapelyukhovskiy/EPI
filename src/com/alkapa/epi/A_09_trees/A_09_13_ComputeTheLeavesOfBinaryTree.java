package com.alkapa.epi.A_09_trees;

import java.util.ArrayList;
import java.util.List;

public class A_09_13_ComputeTheLeavesOfBinaryTree {
    public static List<Integer> getLeaves(BinaryTreeNode<Integer> tree) {
        List<Integer> leaves = new ArrayList<>();
        traverse(tree, leaves);
        return leaves;
    }

    public static void traverse(BinaryTreeNode<Integer> tree, List<Integer> leaves) {
        if (tree == null) {
            return;
        }
        traverse(tree.left, leaves);
        if (tree.left == null && tree.right == null) {
            leaves.add(tree.data);
        }
        traverse(tree.right, leaves);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> tree = BinaryTreeNode.createBalancedBinaryTree();
        List<Integer> leaves = getLeaves(tree);
        for (Integer i : leaves) {
            System.out.println(i);
        }
    }
}
