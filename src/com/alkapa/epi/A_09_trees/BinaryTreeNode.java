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
}
