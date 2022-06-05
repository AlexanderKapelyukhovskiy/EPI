package com.alkapa.epi.trees;


public class A_09_00_Traversal {
    public static void treeTraversal(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.println("Preorder: " + root.data);
        treeTraversal(root.left);
        System.out.println("Inorder: " + root.data);
        treeTraversal(root.right);
        System.out.println("Postorder: " + root.data);
    }

    public static void inorder (BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static void preorder (BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder (BinaryTreeNode<Integer> root) {
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
