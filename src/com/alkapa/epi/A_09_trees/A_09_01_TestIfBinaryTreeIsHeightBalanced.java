package com.alkapa.epi.A_09_trees;

public class A_09_01_TestIfBinaryTreeIsHeightBalanced {
    public static BalanceStatusWithWeight checkBalance(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new BalanceStatusWithWeight(true, -1);
        }

        BalanceStatusWithWeight leftResult = checkBalance(root.left);
        if (!leftResult.balanced) {
            return leftResult;
        }
        BalanceStatusWithWeight rightResult = checkBalance(root.right);
        if (!rightResult.balanced) {
            return rightResult;
        }

        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalanceStatusWithWeight(isBalanced, height);
    }
    public static void test(BinaryTreeNode<Integer> root) {
        BalanceStatusWithWeight res = checkBalance(root);
        System.out.println(res.balanced);
        System.out.println(res.height);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> notBalanced = BinaryTreeNode.createNotBalancedBinaryTree();
        test(notBalanced);

        BinaryTreeNode<Integer> balanced = BinaryTreeNode.createBalancedBinaryTree();
        test(balanced);
    }
}
