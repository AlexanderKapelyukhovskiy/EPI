package com.alkapa.epi.A_09_trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A_09_14_ComputeTheExteriorOfBinaryTree {
    public static List<Integer> exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
        if (tree == null) {
            return Collections.emptyList();
        }

        List<Integer> exterior = new ArrayList<>();
        exterior.add(tree.data);

        leftBoundary(tree.left, exterior);
        leaves(tree.left, exterior);
        leaves(tree.right, exterior);
        rightBoundary(tree.right, exterior);

        return exterior;
    }

    public static void leftBoundary(BinaryTreeNode<Integer> tree, List<Integer> exterior) {
        if (tree == null || tree.left == null && tree.right == null) {
            return;
        }

        exterior.add(tree.data);
        if (tree.left != null) {
            leftBoundary(tree.left, exterior);
        } else {
            leftBoundary(tree.right, exterior);
        }
    }

    public static void rightBoundary(BinaryTreeNode<Integer> tree, List<Integer> exterior) {
        if (tree == null || tree.left == null && tree.right == null) {
            return;
        }
        if (tree.right != null) {
            rightBoundary(tree.right, exterior);
        } else {
            rightBoundary(tree.left, exterior);
        }
        exterior.add(tree.data);
    }

    public static void leaves(BinaryTreeNode<Integer> tree, List<Integer> exterior) {
        if (tree == null) {
            return;
        }

        if (tree.left == null && tree.right == null) {
            exterior.add(tree.data);
        } else {
            leaves(tree.left, exterior);
            leaves(tree.right, exterior);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> tree = BinaryTreeNode.createBalancedBinaryTree();
        List<Integer> exterior = exteriorBinaryTree(tree);

        for (Integer i : exterior) {
            System.out.println(i);
        }
    }
}
