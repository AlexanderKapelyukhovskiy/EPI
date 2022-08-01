package com.alkapa.epi.A_14_binary_search_trees;

import com.alkapa.epi.A_09_trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class A_14_05_ReconstructABSTFromTraversalData {
    public static BinaryTreeNode<Integer> rebuildBSTFromPreorder(List<Integer> traversal) {
        return rebuildBSTFromPreorderHelperV2(traversal, 0, traversal.size());
    }

    public static BinaryTreeNode<Integer> rebuildBSTFromPreorderV2(List<Integer> traversal) {
        rootIndex = 0;
        return rebuildBSTFromPreorderOnValueRange(traversal, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static BinaryTreeNode<Integer> rebuildBSTFromPreorderHelper(List<Integer> traversal, int begin, int end) {
        if (begin >= traversal.size() || begin>end){
            return null;
        }
        if (begin == end) {
            return new BinaryTreeNode<>(traversal.get(begin));
        }
        Integer data = traversal.get(begin);
        int rightIndex = begin + 1;
        while (rightIndex < traversal.size() && traversal.get(rightIndex) < data) {
            rightIndex++;
        }

        BinaryTreeNode leftNode = rebuildBSTFromPreorderHelper(traversal, begin+1, rightIndex - 1);
        BinaryTreeNode rightNode = rebuildBSTFromPreorderHelper(traversal, rightIndex, end);

        return new BinaryTreeNode(data,leftNode,rightNode);
    }

    private static BinaryTreeNode<Integer> rebuildBSTFromPreorderHelperV2(List<Integer> traversal, int start, int end) {
        if (start >= end) {
            return null;
        }
        Integer data = traversal.get(start);

        int transitionPoint = start + 1;
        while (transitionPoint < end && data > traversal.get(transitionPoint)) {
            transitionPoint++;
        }
        BinaryTreeNode leftNode = rebuildBSTFromPreorderHelperV2(traversal, start + 1, transitionPoint);
        BinaryTreeNode rightNode = rebuildBSTFromPreorderHelperV2(traversal, transitionPoint, end);
        return new BinaryTreeNode<>(data, leftNode, rightNode);

    }
    private static int rootIndex;

    private static BinaryTreeNode<Integer> rebuildBSTFromPreorderOnValueRange(
            List<Integer> preorderSequence,
            int lowerBound, int upperBound) {
        if (rootIndex == preorderSequence.size()) {
            return null;
        }
        Integer root = preorderSequence.get(rootIndex);

        if (root < lowerBound || root > upperBound) {
            return null;
        }
        ++rootIndex;
        BinaryTreeNode leftNode = rebuildBSTFromPreorderOnValueRange(preorderSequence, lowerBound, root);
        BinaryTreeNode rightNode = rebuildBSTFromPreorderOnValueRange(preorderSequence, root, upperBound);
        return new BinaryTreeNode<>(root, leftNode, rightNode);
    }

    public static void main(String[] args) {
        List<Integer> traversal = new ArrayList<>();
        traversal.add(43);
        traversal.add(23);
        traversal.add(37);
        traversal.add(29);
        traversal.add(31);
        traversal.add(41);
        traversal.add(47);
        traversal.add(53);
        BinaryTreeNode<Integer> tree = rebuildBSTFromPreorder(traversal);

        BinaryTreeNode<Integer> tree2 = rebuildBSTFromPreorderV2(traversal);

    }
}
