package com.alkapa.epi.A_14_binary_search_trees;

import com.alkapa.epi.A_09_trees.BinaryTreeNode;

public class A_14_09_TestIfThreeNodesAreTotallyOrdered {
    public static boolean test(BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b, BinaryTreeNode<Integer> middle ) {
        if (a.data > b.data) {
            BinaryTreeNode temp = a;
            a = b;
            b = temp;
        }
        if (middle.data < a.data || middle.data > b.data) {
            return false;
        }

        BinaryTreeNode<Integer> iterA = a, iterB = b;

        while ((iterA != null || iterB != null) && iterA != middle && iterB != middle) {
            if (iterA != null && iterA != middle) {
                iterA = iterA.data < middle.data ? iterA.right : iterA.left;
            }
            if (iterB != null && iterB != middle) {
                iterB = iterB.data < middle.data ? iterB.right : iterB.left;
            }
        }

        if (iterA == null && iterB == null) {
            return false;
        }

        BinaryTreeNode<Integer> next = iterA == middle  ? b : a;

        while (middle != null && middle != next) {
            middle = middle.data < next.data ? middle.right : middle.left;
        }

        return middle != null;
    }

    public static void main(String[] arg) {
        BinaryTreeNode<Integer> bst = BinaryTreeNode.createBSTTree();
        BinaryTreeNode<Integer> n23 = A_14_02_FindTheKeyGreaterThanAGivenValueInABst.findFirstBiggerThanK(bst, 22);

        BinaryTreeNode<Integer> n19 = A_14_02_FindTheKeyGreaterThanAGivenValueInABst.findFirstBiggerThanK(bst, 18);
        BinaryTreeNode<Integer> n37 = A_14_02_FindTheKeyGreaterThanAGivenValueInABst.findFirstBiggerThanK(bst, 36);

        BinaryTreeNode<Integer> n43 = A_14_02_FindTheKeyGreaterThanAGivenValueInABst.findFirstBiggerThanK(bst, 42);
        BinaryTreeNode<Integer> n31 = A_14_02_FindTheKeyGreaterThanAGivenValueInABst.findFirstBiggerThanK(bst, 30);

        System.out.println(test(n19, n37, n23));
        System.out.println(test(n43, n31, n23));
    }
}
