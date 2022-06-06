package com.alkapa.epi.trees;

public class A_09_06_FindRootToLeafPathWithSpecifiedSum {
    public static boolean hasPathSum(BinaryTreeNode<Integer> root, Integer sum, Integer partialPathSum) {
        if ( root == null) {
            return false;
        }

        partialPathSum += root.data;
        if ( partialPathSum == sum) {
            return true;
        }

        if (hasPathSum(root.left, sum, partialPathSum)) {
            return true;
        }

        if (hasPathSum(root.right, sum, partialPathSum)) {
            return true;
        }

        return false;
    }

    public static boolean hasPathSumV2(BinaryTreeNode<Integer> root, Integer remainingWeight) {
        if ( root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.data == remainingWeight;
        }

        return hasPathSumV2(root.left, remainingWeight - root.data)
                || hasPathSumV2(root.right, remainingWeight - root.data);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeNode.createBalancedBinaryTree();
        boolean hasPathSum = hasPathSumV2(root, 7);
        System.out.println(hasPathSum);
    }
}
