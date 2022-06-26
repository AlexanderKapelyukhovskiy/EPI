package com.alkapa.epi.A_09_trees;

public class A_09_08_ComputeKthNodeInInorderTraversal {
    public static BinaryTreeNode<Integer> findKthNode(BinaryTreeNode<Integer> tree, int k) {

        BinaryTreeNode<Integer> iter = tree;

        while (iter != null) {
            int leftSize = iter.left != null ? iter.data : 0;

            if (leftSize + 1 < k) {
                k -= (leftSize + 1);
                iter = iter.right;
            } else if (k == leftSize - 1) {
                return iter;
            } else {
                iter = iter.left;
            }
        }

        return null;
    }
}
