package com.alkapa.epi.A_14_binary_search_trees;

public class A_14_00_SearchBST {
    public static BstNode<Integer> searchBST(BstNode<Integer> tree, int key) {
        return (tree == null || tree.data == key)
                    ? tree
                    : (key < tree.data)
                        ? searchBST(tree.left, key)
                        : searchBST(tree.right, key);
    }

    public static void main(String[] args) {
        BstNode<Integer> root
                = new BstNode<>(5,
                    new BstNode<>(3,
                            new BstNode<>(1, null, null),
                            new BstNode<>(4, null, null)),
                    new BstNode<>(7,
                            new BstNode<>(6, null, null),
                            new BstNode<>(8, null, null)));

        BstNode node1 = searchBST(root, 1);
        BstNode node4 = searchBST(root, 4);

        BstNode node6 = searchBST(root, 6);
        BstNode node8 = searchBST(root, 8);

        BstNode node3 = searchBST(root, 3);
        BstNode node7 = searchBST(root, 7);

        BstNode node5 = searchBST(root, 5);

        BstNode node9 = searchBST(root, 9);

        System.out.println(node1.data);
        System.out.println(node4.data);

        System.out.println(node6.data);
        System.out.println(node8.data);

        System.out.println(node3.data);
        System.out.println(node7.data);

        System.out.println(node5.data);

        System.out.println(node9==null);
    }
}
