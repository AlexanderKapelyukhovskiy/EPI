package com.alkapa.epi.A_14_binary_search_trees;

import com.alkapa.epi.A_09_trees.BinaryTreeNode;

public class A_14_04_ComputeTheLCAInABST {
    public static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> tree,
                                                  BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b) {
        BinaryTreeNode<Integer> iter = tree;
        if (a.data > b.data) {
            BinaryTreeNode<Integer> temp = a;
            a = b;
            b = temp;
        }
        while (iter != null) {
            if (a == iter || b == iter) {
                return iter;
            }
            if (iter.data > a.data && iter.data <= b.data) {
                return iter;
            } else if (iter.data < a.data ) {
                iter = iter.right;
            } else  if (iter.data > b.data){
                iter = iter.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> bst = BinaryTreeNode.createBSTTree();
        BinaryTreeNode<Integer> n3 = A_14_02_FindTheKeyGreaterThanAGivenValueInABst.findFirstBiggerThanK(bst, 2);
        BinaryTreeNode<Integer> n17 = A_14_02_FindTheKeyGreaterThanAGivenValueInABst.findFirstBiggerThanK(bst, 13);

        BinaryTreeNode lca = findLCA(bst, n17, n3);
        System.out.println(lca.data);
    }
}
