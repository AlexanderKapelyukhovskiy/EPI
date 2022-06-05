package com.alkapa.epi.trees;

public class A_09_03_ComputeTheLowestCommonAncestorInBinaryTree {

    private static class Status {
        public int numTargetNodes;
        public BinaryTreeNode<Integer> ancestor;

        public Status(int numTargetNodes, BinaryTreeNode<Integer> ancestor) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = ancestor;
        }
    }

    public static BinaryTreeNode<Integer> lca (
            BinaryTreeNode<Integer> tree,
            BinaryTreeNode<Integer> node0,
            BinaryTreeNode<Integer> node1) {
        return lcaHelper(tree, node0, node1).ancestor;
    }

    public static Status lcaHelper(
            BinaryTreeNode<Integer> tree,
            BinaryTreeNode<Integer> node0,
            BinaryTreeNode<Integer> node1) {
        if (tree == null) {
            return new Status(0, null);
        }

        Status leftResult = lcaHelper(tree.left, node0, node1);
        if (leftResult.numTargetNodes == 2) {
            return leftResult;
        }
        Status rightResult = lcaHelper(tree.right, node0, node1);
        if (rightResult.numTargetNodes == 2) {
            return rightResult;
        }

        int numberOfTargets = leftResult.numTargetNodes + rightResult.numTargetNodes
                + (tree == node0 ? 1 : 0)
                + (tree == node1 ? 1 : 0);

        return new Status(numberOfTargets, numberOfTargets == 2 ? tree : null);
    }

    public static BinaryTreeNode<Integer> findParent(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> node) {
        if (tree == null) {
            return null;
        }

        if (node == tree.left || node == tree.right) {
            return tree;
        }

        BinaryTreeNode res = findParent(tree.left, node);
        if (res != null) {
            return tree.left;
        }

        res = findParent(tree.right, node);
        if (res != null) {
            return tree.right;
        }

        return null;
    }

    public static BinaryTreeNode<Integer> findLCA(
            BinaryTreeNode<Integer> tree,
            BinaryTreeNode<Integer> first, BinaryTreeNode<Integer> second) {

        if (tree == null) {
            return null;
        }

        if (first == null && second == null) {
            return null;
        }

        if (first == null && second != null || first != null && second == null) {
            return null;
        }

        if (first == second) {
            return first;
        }

        BinaryTreeNode<Integer> firstParent = findParent(tree, first);
        if (firstParent == null) {
            return null;
        }
        BinaryTreeNode<Integer> secondParent = findParent(tree, second);
        if (secondParent == null) {
            return null;
        }

        if (firstParent == tree && secondParent == tree
                || firstParent == tree.left && secondParent == tree.right
                || firstParent == tree.right && secondParent == tree.left) {
            return tree;
        }

        return findLCA(firstParent, first, second);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> first = new BinaryTreeNode<Integer>(1);
        BinaryTreeNode<Integer> second = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> tree =
                new BinaryTreeNode<Integer>(0,
                        new BinaryTreeNode<Integer>(3,
                                new BinaryTreeNode<Integer>(4, first, null),
                                new BinaryTreeNode<Integer>(5, null, second)),
                        null);

        //BinaryTreeNode lca = findLCA(tree, first, second);
        BinaryTreeNode lca = lca(tree, first, second);
        System.out.println(lca.data);
    }
}
