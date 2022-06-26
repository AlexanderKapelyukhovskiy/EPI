package com.alkapa.epi.A_09_trees;

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

    public static BinaryTree<Integer> createTree() {
        BinaryTree<Integer> node1 = new BinaryTree<Integer>(1, null, null, null);

        BinaryTree<Integer> node2 = new BinaryTree<Integer>(2, node1, null, null);
        node1.left = node2;

        BinaryTree<Integer> node4 = new BinaryTree<Integer>(4, node2, null, null);
        node2.left = node4;

        BinaryTree<Integer> node5 = new BinaryTree<Integer>(5, node2, null, null);
        node2.right = node5;


        BinaryTree<Integer> node3 = new BinaryTree<Integer>(3, node1, null, null);
        node1.right = node3;

        BinaryTree<Integer> node6 = new BinaryTree<Integer>(6, node3, null, null);
        node3.left = node6;

        BinaryTree<Integer> node7 = new BinaryTree<Integer>(7, node3, null, null);
        node3.right = node7;

        return node1;
    }
}
