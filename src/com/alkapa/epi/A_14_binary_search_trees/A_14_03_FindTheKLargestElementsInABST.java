package com.alkapa.epi.A_14_binary_search_trees;

import com.alkapa.epi.A_09_trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class A_14_03_FindTheKLargestElementsInABST {
    public static List<Integer> findKLargestInBST(BinaryTreeNode<Integer> tree, int k) {
        List<Integer> largest = new ArrayList<>();
        findKLargestInBSTHelper(tree, k, largest);
        return largest;
    }

    public static void findKLargestInBSTHelper(BinaryTreeNode<Integer> subtree, int k, List<Integer> largest) {
        if (subtree == null || largest.size() >= k) {
            return;
        }
        findKLargestInBSTHelper(subtree.right, k, largest);
        if (largest.size() < k) {
            largest.add(subtree.data);
            findKLargestInBSTHelper(subtree.left, k, largest);
        }
    }

    public static void main(String[] args) {
        List<Integer> largest = findKLargestInBST(BinaryTreeNode.createBSTTree(), 3);
        for(Integer l : largest) {
            System.out.println(l);
        }
    }
}
