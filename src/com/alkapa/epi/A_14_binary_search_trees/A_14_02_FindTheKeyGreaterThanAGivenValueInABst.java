package com.alkapa.epi.A_14_binary_search_trees;

import com.alkapa.epi.A_09_trees.BinaryTreeNode;

public class A_14_02_FindTheKeyGreaterThanAGivenValueInABst {
    public static Integer findFirstBiggerThem(BinaryTreeNode<Integer> tree, Integer target){
        BinaryTreeNode<Integer> iter = tree;
        return findeHelper(iter, target, null);
    }

    public static BinaryTreeNode<Integer> findFirstBiggerThanK(BinaryTreeNode<Integer> tree, Integer K) {
        BinaryTreeNode<Integer> subTree = tree;
        BinaryTreeNode<Integer> firstSoFar = null;

        while (subTree != null) {
            if (subTree.data > K) {
                firstSoFar = subTree;
                subTree = subTree.left;
            } else {
                subTree = subTree.right;
            }
        }
        return firstSoFar;

    }


    private static Integer findeHelper(BinaryTreeNode<Integer> node, Integer target, Integer prev) {
        if (node == null) {
            return prev;
        }
        if (node.data > target) {
            return findeHelper(node.left, target, node.data > target ? node.data : prev);
        } else if (node.data <= target) {
            return findeHelper(node.right, target, node.data > target ? node.data : prev);
        } else {
            return prev;
        }
    }

    public static void main (String[] args) {
        System.out.println(findFirstBiggerThanK( BinaryTreeNode.createBSTTree(), 23).data);
    }
}
