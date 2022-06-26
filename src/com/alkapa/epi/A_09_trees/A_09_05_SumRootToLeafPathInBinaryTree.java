package com.alkapa.epi.A_09_trees;

public class A_09_05_SumRootToLeafPathInBinaryTree {
    public static int sum(BinaryTreeNode<Integer> root) {
        return sumRootToLeafHelper(root, 0);
    }

    public static int sumRootToLeafHelper(BinaryTreeNode<Integer> root, int partialPathSum) {
        if (root == null) {
            return 0;
        }

        partialPathSum = 2 * partialPathSum + root.data;
        if (root.left == null && root.right == null) {
            return partialPathSum;
        }

        return sumRootToLeafHelper(root.left, partialPathSum) + sumRootToLeafHelper(root.right, partialPathSum);
    }

    public static void main (String[] args) {
        BinaryTreeNode<Integer> root =
                new BinaryTreeNode<>(1,
                        new BinaryTreeNode<>(0,
                                new BinaryTreeNode<>(1,null,null),
                                null),
                        null);

        int sum = sum(root);
        System.out.println(sum);
    }
}
