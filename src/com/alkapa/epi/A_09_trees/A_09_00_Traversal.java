package com.alkapa.epi.A_09_trees;

public class A_09_00_Traversal {
    public static void treeTraversal(BinaryTreeNode<Integer> root) {
        treeTraversal(root, false);
    }

    public static void treeTraversal(BinaryTreeNode<Integer> root, boolean convertToChar) {
        if (root == null) {
            return;
        }

        System.out.println("Preorder: " + root.data + " " + (convertToChar && root.data != null ? (char) root.data.intValue() : ' '));
        treeTraversal(root.left, convertToChar);
        System.out.println("Inorder: " + root.data + " " + (convertToChar && root.data != null ? (char) root.data.intValue() : ' '));
        treeTraversal(root.right, convertToChar);
        System.out.println("Postorder: " + root.data + " " + (convertToChar && root.data != null ? (char) root.data.intValue() : ' '));
    }

    public static void inorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void preorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(
                1,
                new BinaryTreeNode<>(2, new BinaryTreeNode<>(3), new BinaryTreeNode<>(4)),
                new BinaryTreeNode<>(5, new BinaryTreeNode<>(6), new BinaryTreeNode<>(7))
        );

        System.out.println("Inorder:");
        inorder(root);
        System.out.println("Preorder:");
        preorder(root);
        System.out.println("Postorder:");
        postorder(root);
        System.out.println("ALL:");
        treeTraversal(root);
    }
}
