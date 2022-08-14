package com.alkapa.epi.A_15_recursion;

import com.alkapa.epi.A_09_trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A_15_09_GenerateBinaryTrees {
    private static Map<Integer, List<BinaryTreeNode<Integer>>> cache = new HashMap<>();

    public static List<BinaryTreeNode<Integer>> generateAllBinaryTrees(int numNodes) {
        List<BinaryTreeNode<Integer>> result = new ArrayList<>();

        if (numNodes == 0) {
            result.add(null);
        }

        for (int numberLeftTreeNode = 0; numberLeftTreeNode < numNodes; ++numberLeftTreeNode) {
            int numberRightTreeNode = numNodes - 1 - numberLeftTreeNode;

            List<BinaryTreeNode<Integer>> leftSubtrees;
            if (cache.get(numberLeftTreeNode) != null) {
                leftSubtrees = cache.get(numberLeftTreeNode);
            } else {
                leftSubtrees = generateAllBinaryTrees(numberLeftTreeNode);
                cache.put(numberLeftTreeNode, leftSubtrees);
            }

            List<BinaryTreeNode<Integer>> rightSubtrees;
            if (cache.get(numberRightTreeNode) != null) {
                rightSubtrees = cache.get(numberRightTreeNode);
            } else {
                rightSubtrees = generateAllBinaryTrees(numberRightTreeNode);
                cache.put(numberRightTreeNode, rightSubtrees);
            }

            for (BinaryTreeNode<Integer> left : leftSubtrees) {
                for (BinaryTreeNode<Integer> right : rightSubtrees) {
                    result.add(new BinaryTreeNode<>(0, left, right));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<BinaryTreeNode<Integer>> res = generateAllBinaryTrees(3);
    }
}