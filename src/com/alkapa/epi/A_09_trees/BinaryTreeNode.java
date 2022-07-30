package com.alkapa.epi.A_09_trees;

public class BinaryTreeNode<T> {//extends TreeLike<T, BinaryTreeNode<T>> {}
    public T data;
    public BinaryTreeNode<T> left, right;

    public BinaryTreeNode(T d, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.data = d;
        this.left = left;
        this.right = right;
    }
    public BinaryTreeNode(T data) {
        this(data, null, null);
    }

    public static BinaryTreeNode<Integer> createBalancedBinaryTree() {
        return  new BinaryTreeNode<>(
                1,
                new BinaryTreeNode<>(2, new BinaryTreeNode<>(3), new BinaryTreeNode<>(4)),
                new BinaryTreeNode<>(5, new BinaryTreeNode<>(6), new BinaryTreeNode<>(7))
        );
    }

    public static BinaryTreeNode<Integer> createNotBalancedBinaryTree() {
        return new BinaryTreeNode<>(
                1,
                new BinaryTreeNode<>(2, new BinaryTreeNode<>(3),
                        new BinaryTreeNode<>(4,
                                new BinaryTreeNode<>(5,
                                        new BinaryTreeNode<>(6),
                                        new BinaryTreeNode<>(7)),
                                null)),
                null);
    }

    public static BinaryTreeNode<Integer> createBSTTree() {
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
        return bstTree;
    }
}
