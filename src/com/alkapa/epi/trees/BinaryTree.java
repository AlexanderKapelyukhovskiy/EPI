package com.alkapa.epi.trees;

public class BinaryTree<T> {
    public T data;
    public BinaryTree<T> left, right, parent;

    public BinaryTree(T d, BinaryTree<T> parent, BinaryTree<T> left, BinaryTree<T> right) {
        this.data = d;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public BinaryTree(T data) {
        this(data, null, null, null);
    }
}
