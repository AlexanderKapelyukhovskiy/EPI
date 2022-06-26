package com.alkapa.epi.A_09_trees;

public class A_09_02_TestIfBinaryTreeIsSymmetric {

    public static boolean isSymmetric(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }

    public static boolean checkSymmetric(BinaryTreeNode left, BinaryTreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }

        if (left.data != right.data) {
            return false;
        }
        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> symmetric =
                new BinaryTreeNode<Integer>(0,
                        new BinaryTreeNode<>(1, new BinaryTreeNode<>(2), null),
                        new BinaryTreeNode<>(1, null, new BinaryTreeNode<>(2)));

        System.out.println(isSymmetric(symmetric));

        BinaryTreeNode<Integer> nonSymmetric = BinaryTreeNode.createBalancedBinaryTree();
        System.out.println(isSymmetric(nonSymmetric));
    }
}
