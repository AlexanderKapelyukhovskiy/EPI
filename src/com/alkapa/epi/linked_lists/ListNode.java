package com.alkapa.epi.linked_lists;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode() {

    }
    public ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(T data ) {
        this(data, null);
    }

    public static void printList(ListNode<Integer> L) {
        if (L == null) {
            System.out.println("Empty List");
            return;
        }

        boolean first = true;

        while (L != null) {
            if (first) {
                System.out.print(L.data);
                first = false;
            } else {
                System.out.print(", " + L.data);
            }

            L = L.next;
        }
        System.out.println();
    }

    public static ListNode<Integer> createTestList(int size) {
        ListNode<Integer> dummyHead = new ListNode<>(0);
        ListNode<Integer> L1 = dummyHead;

        for (int i = 1; i < size; ++i) {
            L1.next = new ListNode<>(i);
            L1 = L1.next;
        }

        return dummyHead;
    }
}
