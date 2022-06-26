package com.alkapa.epi.A_08_stacks_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A_08_06_ComputeBinaryTreeNodesInOrderIncreasingDepth {
    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
        List<List<Integer>> result = new ArrayList<>();
        if (tree == null) {
            return result;
        }
        List<BinaryTreeNode<Integer>> currentDepthNodes = List.of(tree);
        while(!currentDepthNodes.isEmpty()) {
            result.add(currentDepthNodes.stream().map(curr -> curr.data).collect(Collectors.toList()));

            currentDepthNodes = currentDepthNodes.stream()
                    .map(curr -> Arrays.asList(curr.left, curr.right))
                    .flatMap(List::stream).filter( child -> child != null)
                    .collect(Collectors.toList());
        }
        return result;
    }
}
