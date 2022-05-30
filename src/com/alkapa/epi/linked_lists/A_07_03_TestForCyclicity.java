package com.alkapa.epi.linked_lists;

public class A_07_03_TestForCyclicity {
    public static ListNode<Integer> hasCycle(ListNode<Integer> head) {
        ListNode fast = head, slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int cycleLen = 0;
                do {
                    ++cycleLen;
                    fast = fast.next;
                } while (slow != fast);

                ListNode<Integer> cycleLenAdvancedIterator = head;
                while (cycleLen-- >0) {
                    cycleLenAdvancedIterator = cycleLenAdvancedIterator.next;
                }

                ListNode<Integer> iterator = head;
                while (iterator != cycleLenAdvancedIterator) {
                    iterator = iterator.next;
                    cycleLenAdvancedIterator = cycleLenAdvancedIterator.next;
                }

                return iterator;
            }
        }
        return null;
    }
}
