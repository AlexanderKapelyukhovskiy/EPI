package com.alkapa.epi.A_09_trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A_09_11_ReconstructBinaryTreeFromTraversalData {
    public static BinaryTreeNode<Integer> buildTreeFromPreorderInorder(
            List<Integer> preorder, List<Integer> inorder) {

        Map<Integer, Integer> nodeToInorderIdx = IntStream.range(0, inorder.size()).boxed()
                .collect(Collectors.toMap(i -> inorder.get(i), i -> i));

        return buildTreeFromPreorderInorderHelper(
                preorder, 0, preorder.size(),
                0, inorder.size(), nodeToInorderIdx
        );
    }

    public static BinaryTreeNode<Integer> buildTreeFromPreorderInorderHelper(
            List<Integer> preorder, int preorderStart, int preorderEnd,
            int inorderStart, int inorderEnd, Map<Integer, Integer> nodeToInorderIdx) {
        if (preorderEnd <= preorderStart || inorderEnd <= inorderStart) {
            return null;
        }
        int rootInorderIdx = nodeToInorderIdx.get(preorder.get(preorderStart));
        int leftInorderSize = rootInorderIdx - inorderStart;

        return new BinaryTreeNode<>(preorder.get(preorderStart),
                buildTreeFromPreorderInorderHelper(
                        preorder,
                        preorderStart + 1, preorderStart + 1 + leftInorderSize,
                        inorderStart, rootInorderIdx, nodeToInorderIdx ),
                buildTreeFromPreorderInorderHelper(
                        preorder,
                        preorderStart + 1 + leftInorderSize, preorderEnd,
                        rootInorderIdx + 1, inorderEnd, nodeToInorderIdx ));
    }

    public static void main (String[] args) {
        List<Integer> inorder = new ArrayList<>();
        inorder.add((int)'F');
        inorder.add((int)'B');
        inorder.add((int)'A');
        inorder.add((int)'E');
        inorder.add((int)'H');
        inorder.add((int)'C');
        inorder.add((int)'D');
        inorder.add((int)'I');
        inorder.add((int)'G');

        List<Integer> preorder = new ArrayList<>();
        preorder.add((int)'H');
        preorder.add((int)'B');
        preorder.add((int)'F');
        preorder.add((int)'E');
        preorder.add((int)'A');
        preorder.add((int)'C');
        preorder.add((int)'D');
        preorder.add((int)'G');
        preorder.add((int)'I');

        BinaryTreeNode<Integer> tree = buildTreeFromPreorderInorder(preorder, inorder);

        A_09_00_Traversal.treeTraversal(tree);
    }
}
