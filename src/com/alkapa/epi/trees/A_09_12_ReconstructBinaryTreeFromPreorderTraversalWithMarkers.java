package com.alkapa.epi.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class A_09_12_ReconstructBinaryTreeFromPreorderTraversalWithMarkers {

    public static BinaryTreeNode<Integer> reconstructV2(List<Integer> preorder) {
        return reconstructV2Helper(preorder, 0);
    }

    public static BinaryTreeNode<Integer> reconstructV2Helper(List<Integer> preorder, int index) {
        Integer current = preorder.get(index);
        if (current == null) {
            return null;
        }

        BinaryTreeNode<Integer> left = reconstructV2Helper(preorder, ++index);
        BinaryTreeNode<Integer> right = reconstructV2Helper(preorder, ++index);
        return new BinaryTreeNode<>(current, left, right);
    }

    public static BinaryTreeNode<Integer> reconstruct(List<Integer> preorder) {
        Deque<BinaryTreeNode<Integer>> stack = new ArrayDeque<>();
        BinaryTreeNode<Integer> node = null;
        for (int i = preorder.size() - 1; i >= 0; --i) {
            if (preorder.get(i) == null) {
                stack.push(new BinaryTreeNode<Integer>(null));
            } else {
                BinaryTreeNode<Integer> left = stack.pop();
                BinaryTreeNode<Integer> right = stack.pop();
                if (left != null && left.data == null) {
                    left = null;
                }
                if (right != null && right.data == null) {
                    right = null;
                }

                node = new BinaryTreeNode<>(preorder.get(i), left, right);
                stack.push(node);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        List<Integer> preorder = new ArrayList<>();
        preorder.add((int) 'H');
        preorder.add((int) 'B');
        preorder.add((int) 'F');
        preorder.add(null);
        preorder.add(null);
        preorder.add((int) 'E');
        preorder.add((int) 'A');
        preorder.add(null);
        preorder.add(null);
        preorder.add(null);
        preorder.add((int) 'C');
        preorder.add(null);
        preorder.add((int) 'D');
        preorder.add(null);
        preorder.add((int) 'G');
        preorder.add((int) 'I');
        preorder.add(null);
        preorder.add(null);
        preorder.add(null);

        BinaryTreeNode<Integer> tree = reconstructV2(preorder);
        A_09_00_Traversal.treeTraversal(tree, true);
    }
}
