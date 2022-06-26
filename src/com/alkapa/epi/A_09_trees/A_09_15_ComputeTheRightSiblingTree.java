package com.alkapa.epi.A_09_trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class A_09_15_ComputeTheRightSiblingTree {
    public static BinaryTree<Integer> rightSibling(BinaryTree<Integer> tree) {
        Deque<BinaryTree<Integer>> stack = new ArrayDeque<>();
        traverse(tree, stack);
        return tree;
    }

    public static void traverse(BinaryTree<Integer> tree, Deque<BinaryTree<Integer>> stack) {
        if (tree == null) {
            return;
        }

        if (tree.right != null) {
            stack.push(tree.right);
        }
        traverse(tree.left, stack);
        if (!stack.isEmpty()) {
            BinaryTree<Integer> next = stack.pop();
            tree.parent = next;
        }
        traverse(tree.right, stack);
    }

    public static BinaryTree<Integer> fillNext(BinaryTree<Integer> tree) {
        BinaryTree<Integer> iter = tree;
        while (iter != null) {
            fillLevel(iter);
            iter = iter.left;
        }
        return tree;
    }

    public static void fillLevel(BinaryTree<Integer> node) {
        while (node != null || node.left != null || node.right != null) {
            node.left.parent = node.right;
            if (node.parent != null) {
                node.right.parent = node.parent.left;
            }
            node = node.parent;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = BinaryTree.createTree();

        BinaryTree<Integer> res = rightSibling(tree);
    }
}
