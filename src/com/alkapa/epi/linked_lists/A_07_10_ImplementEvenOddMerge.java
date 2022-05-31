package com.alkapa.epi.linked_lists;

public class A_07_10_ImplementEvenOddMerge {
    public static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
        ListNode<Integer> dummyEvenHead = new ListNode<>(0);
        ListNode<Integer> dummyOddHead = new ListNode<>(0);
        ListNode<Integer> oddIterator = dummyOddHead;
        ListNode<Integer> evenIterator = dummyEvenHead;

        while (L != null) {
            if (L.data % 2 == 0) {
                evenIterator.next = L;
                evenIterator = evenIterator.next;
            } else {
                oddIterator.next = L;
                oddIterator = oddIterator.next;
            }
            L = L.next;
        }
        evenIterator.next = dummyOddHead.next;

        return dummyEvenHead.next;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.createTestList(10);
        ListNode.printList(list);
        ListNode res = evenOddMerge(list);
        ListNode.printList(res);
    }
}
