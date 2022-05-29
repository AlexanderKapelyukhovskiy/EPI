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
}
