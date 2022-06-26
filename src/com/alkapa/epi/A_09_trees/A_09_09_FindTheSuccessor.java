package com.alkapa.epi.A_09_trees;

public class A_09_09_FindTheSuccessor {
    public static BinaryTree<Integer> findSuccessor(BinaryTree<Integer> node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            while (node.parent != null && node.parent.right == node) {
                node = node.parent;
            }
            return node.parent;
        } else {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> node1 = new BinaryTree<Integer>(1, null, null, null);
        BinaryTree<Integer> node2 = new BinaryTree<Integer>(2, node1, null, null);
        node1.left = node2;
        BinaryTree<Integer> node3 = new BinaryTree<Integer>(3, node2, null, null);
        BinaryTree<Integer> node4 = new BinaryTree<Integer>(4, node2, null, null);
        node2.left = node3;
        node2.right = node4;
        BinaryTree<Integer> node5 = new BinaryTree<Integer>(5, node4, null, null);
        node4.left = node5;

        BinaryTree<Integer> successor1 = findSuccessor(node4);
        BinaryTree<Integer> successor2 = findSuccessor(node5);

        System.out.println(successor1.data);
        System.out.println(successor2.data);
    }
}
