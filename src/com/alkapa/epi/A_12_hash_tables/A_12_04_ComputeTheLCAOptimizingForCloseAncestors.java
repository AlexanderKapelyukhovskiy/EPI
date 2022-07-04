package com.alkapa.epi.A_12_hash_tables;

import com.alkapa.epi.A_09_trees.BinaryTree;

import java.util.HashSet;

public class A_12_04_ComputeTheLCAOptimizingForCloseAncestors {
    public static BinaryTree<Integer> lca (BinaryTree<Integer> tree,
                                           BinaryTree<Integer> node0,
                                           BinaryTree<Integer> node1) {
        HashSet<BinaryTree<Integer>> node0Set = new HashSet<>();
        HashSet<BinaryTree<Integer>> node1Set = new HashSet<>();

        while (node0!=null || node1 != null) {
            if (node0 != null) {
                if (node1Set.contains(node0)) {
                    return node0;
                }
                node0Set.add(node0);
                node0 = node0.parent;
            }

            if (node1 != null) {
                if (node0Set.contains(node1)) {
                    return node1;
                }
                node1Set.add(node1);
                node1 = node1.parent;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(0);

        BinaryTree<Integer> a = new BinaryTree<>(3, root, null, null);
        root.left = a;

        BinaryTree<Integer> node0 = new BinaryTree<>(1, a, null, null);
        a.right = node0;

        BinaryTree<Integer> b = new BinaryTree<>(4, a, null, null);
        a.left = b;

        BinaryTree<Integer> node1 = new BinaryTree<>(2, b, null, null);
        b.right = node1;

        BinaryTree<Integer> lca = lca(root, node0, node1);
    }
}
