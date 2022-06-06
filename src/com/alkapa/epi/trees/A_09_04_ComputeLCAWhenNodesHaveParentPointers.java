package com.alkapa.epi.trees;

public class A_09_04_ComputeLCAWhenNodesHaveParentPointers {
    public static BinaryTree<Integer> lca(
            BinaryTree<Integer> tree,
            BinaryTree<Integer> node0,
            BinaryTree<Integer> node1) {

        int node0Depth = getDepth(node0);
        int node1Depth = getDepth(node1);

        if (node1Depth > node0Depth) {
            BinaryTree<Integer> temp = node0;
            node0 = node1;
            node1 = temp;
        }

        int depthDiff = Math.abs(node0Depth - node1Depth);

        while (depthDiff-- > 0) {
            node0 = node0.parent;
        }

        while (node0.parent != null) {
            if (node0 == node1) {
                return node0;
            }
            node0 = node0.parent;
            node1 = node1.parent;
        }

        return null;
    }

    public static int getDepth(BinaryTree<Integer> node) {
        int depth = 0;
        while (node.parent != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(0);

        BinaryTree<Integer> a = new BinaryTree<>(3, root, null, null);
        root.left = a;

        BinaryTree<Integer> node0 = new BinaryTree<>(1, a, null, null);
        a.right = node0;

        BinaryTree<Integer> b = new BinaryTree<>(4, a, null, null);
        a.left = b;

        BinaryTree<Integer> node1 = new BinaryTree<>(2, b, null, null);
        b.right = node1;

        BinaryTree<Integer> lca = lca(root, node0, node1);
    }
}
