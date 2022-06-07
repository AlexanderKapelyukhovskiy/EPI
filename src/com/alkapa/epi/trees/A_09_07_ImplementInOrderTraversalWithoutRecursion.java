package com.alkapa.epi.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class A_09_07_ImplementInOrderTraversalWithoutRecursion {
    private static class NodeAndStatus {
        BinaryTreeNode<Integer> node;
        boolean leftSubtreeTraversed;

        public NodeAndStatus(BinaryTreeNode<Integer> node, boolean leftSubtreeTraversed) {
            this.node = node;
            this.leftSubtreeTraversed = leftSubtreeTraversed;
        }
    }

    public static List<Integer> inorderTraversal(BinaryTreeNode<Integer> tree) {
        List<Integer> results = new ArrayList<>();
        Deque<NodeAndStatus> inProcess = new ArrayDeque<>();

        inProcess.push(new NodeAndStatus(tree, false));

        while (!inProcess.isEmpty()) {
            NodeAndStatus current = inProcess.pop();

            if (current.node == null) {
                continue;
            }

            if (current.leftSubtreeTraversed) {
                results.add(current.node.data);
            } else {
                inProcess.push(new NodeAndStatus(current.node.right, false));
                inProcess.push(new NodeAndStatus(current.node, true));
                inProcess.push(new NodeAndStatus(current.node.left, false));
            }
        }
        return results;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> tree = BinaryTreeNode.createBalancedBinaryTree();
        List<Integer> list = inorderTraversal(tree);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
