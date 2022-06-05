package com.alkapa.epi.trees;

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
}
