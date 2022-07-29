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
        BinaryTreeNode<Integer> bstTree
                = new BinaryTreeNode<>(19,
                new BinaryTreeNode<>(7,
                        new BinaryTreeNode<>(3,
                            new BinaryTreeNode<>(2, null, null),
                            new BinaryTreeNode<>(5, null, null)),
                        new BinaryTreeNode<>(11,
                        null,
                            new BinaryTreeNode<>(17,
                                    new BinaryTreeNode<>(13, null, null),
                                    null))),
                new BinaryTreeNode<>(43,
                        new BinaryTreeNode<>(23,
                        null,
                            new BinaryTreeNode<>(37,
                                new BinaryTreeNode<>(29,
                                null,
                                    new BinaryTreeNode<>(31, null, null)),
                                new BinaryTreeNode<>(41, null, null))),
                        new BinaryTreeNode<>(47, null,
                            new BinaryTreeNode<>(53, null, null))));

        System.out.println(findFirstBiggerThanK( bstTree, 23).data);
    }
}
