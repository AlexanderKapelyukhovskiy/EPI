package com.alkapa.epi.trees;

import java.util.ArrayList;
import java.util.List;

public class A_09_10_ImplementInorderTraversalWithConstantSpace {
    public static List<Integer> traverse(BinaryTree<Integer> tree) {
        BinaryTree<Integer> current = tree, prev = null;
        List<Integer> result = new ArrayList<>();

        while (current != null) {
            BinaryTree<Integer> next;
            if (current.parent == prev) {
                if (current.left != null) {
                    next = current.left;
                } else {
                    result.add(current.data);
                    next = current.right != null ? current.right : current.parent;
                }
            } else if (current.left == prev) {
                result.add(current.data);
                next = current.right != null ? current.right : current.parent;
            } else {
                next = current.parent;
            }
            prev = current;
            current = next;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = BinaryTree.createTree();

        List<Integer> nodes = traverse(tree);

        for (Integer i : nodes) {
            System.out.println(i);
        }
    }
}
