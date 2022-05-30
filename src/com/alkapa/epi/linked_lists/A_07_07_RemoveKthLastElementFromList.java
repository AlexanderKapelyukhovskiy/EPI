package com.alkapa.epi.linked_lists;

public class A_07_07_RemoveKthLastElementFromList {
    public static ListNode<Integer> removeKthListElement(ListNode<Integer> L, int k) {
        ListNode<Integer> L1 = L;
        for (int i = 0; i < k + 1 && L1 != null; ++i) {
            L1 = L1.next;
        }

        if (L1 == null) {
            return L;
        }

        ListNode<Integer> L2 = L;
        while (L1 != null) {
            L1 = L1.next;
            L2 = L2.next;
        }

        L2.next = L2.next.next;

        return L;
    }

    public static void main(String[] args) {
        ListNode<Integer> L = ListNode.createTestList(5);
        ListNode.printList(L);
        ListNode<Integer> R = removeKthListElement(L, 3);
        ListNode.printList(R);
    }
}
