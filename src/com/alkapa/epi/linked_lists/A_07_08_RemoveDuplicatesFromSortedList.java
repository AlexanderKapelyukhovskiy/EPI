package com.alkapa.epi.linked_lists;

public class A_07_08_RemoveDuplicatesFromSortedList {
    public static ListNode<Integer> removeDuplicates(ListNode<Integer> L) {
        ListNode<Integer> iterator = L;

        while (iterator != null ) {
            while (iterator.next != null && iterator.data == iterator.next.data) {
                iterator.next = iterator.next.next;
            }
            iterator = iterator.next;
        }
        return L;
    }

    public static void main(String[] args) {
        ListNode<Integer> list = new ListNode<>(0, new ListNode(0, ListNode.createTestList(5)));
        ListNode.printList(list);

        ListNode<Integer> r = removeDuplicates(list);
        ListNode.printList(r);

        list = new ListNode<>(0, new ListNode(0, new ListNode<Integer>(0)));
        ListNode.printList(list);

        r = removeDuplicates(list);
        ListNode.printList(r);
    }
}
