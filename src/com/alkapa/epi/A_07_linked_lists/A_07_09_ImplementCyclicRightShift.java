package com.alkapa.epi.A_07_linked_lists;

public class A_07_09_ImplementCyclicRightShift {
    public static ListNode<Integer> cyclicRightShift(ListNode<Integer> L, int k) {
        ListNode<Integer> tail = L;

        int length = 1;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }

        tail.next = L;

        int stepsToNewHead = length - k;
        ListNode<Integer> newTail = tail;

        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        ListNode<Integer> newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public static void main (String[] args) {
        ListNode<Integer> list = ListNode.createTestList(5);
        ListNode.printList(list);

        ListNode<Integer> shifterList = cyclicRightShift(list, 1);
        ListNode.printList(shifterList);
    }
}
