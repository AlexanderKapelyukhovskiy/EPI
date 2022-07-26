package com.alkapa.epi.A_14_binary_search_trees;

public class BstNode<T> {
    public T data;
    public BstNode<T> left, right;

    public BstNode(T data, BstNode<T> left, BstNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
