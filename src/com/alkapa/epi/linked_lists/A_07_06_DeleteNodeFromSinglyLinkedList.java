package com.alkapa.epi.linked_lists;

public class A_07_06_DeleteNodeFromSinglyLinkedList {
    public static void deletionFromList(ListNode<Integer> nodeToDelete) {
        if (nodeToDelete.next == null) {
            throw new IllegalArgumentException("Node could not be a tail");
        }
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
    }
}
