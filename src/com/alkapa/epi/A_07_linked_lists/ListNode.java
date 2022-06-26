package com.alkapa.epi.A_07_linked_lists;

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

    public static ListNode<Integer> reverseList(ListNode<Integer> L) {
        ListNode<Integer> R = null;
        while (L != null) {
            ListNode<Integer> t = L.next;
            L.next = R;
            R = L;
            L = t;
        }
        return R;
    }

    public static ListNode<Integer> concat(ListNode<Integer> L1, ListNode<Integer> L2) {
        ListNode dummyHead = L1;
        while (L1.next != null) {
            L1 = L1.next;
        }
        L1.next = L2;
        return dummyHead;
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
