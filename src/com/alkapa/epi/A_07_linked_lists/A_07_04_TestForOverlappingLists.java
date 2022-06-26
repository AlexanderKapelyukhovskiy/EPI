package com.alkapa.epi.A_07_linked_lists;

public class A_07_04_TestForOverlappingLists {
    public static ListNode<Integer> overlapping(ListNode<Integer> L1, ListNode<Integer> L2) {
        int l1 = length(L1);
        int l2 = length(L2);

        if (l1 > l2) {
            L1 = advanceListByK(l1 - l2, L1);
        } else {
            L2 = advanceListByK(l2 - l1, L2);
        }

        while (L1 != null && L2 != null && L1 != L2) {
            L1 = L1.next;
            L2 = L2.next;
        }

        return L1;
    }

    public static ListNode<Integer> advanceListByK(int k, ListNode<Integer> L) {
        while ( k-- > 0) {
            L = L.next;
        }
        return L;
    }

    public static int length(ListNode<Integer> l) {
        int length = 0;
        while (l != null) {
            l = l.next;
            length++;
        }
        return length;
    }

    public static ListNode<Integer> createL1() {
        ListNode<Integer> L1 = new ListNode<>();
        L1.data = 1;
        L1.next = new ListNode<>();
        L1.next.data = 2;
        L1.next.next = new ListNode<>();
        L1.next.next.data = 3;
        L1.next.next.next = new ListNode<>();
        L1.next.next.next.data = 4;
        L1.next.next.next.next = new ListNode<>();
        L1.next.next.next.next.data = 5;
        return L1;
    }

    public static void main(String[] args) {
        ListNode<Integer> L1 = createL1();

        ListNode<Integer> L2 = new ListNode<>(0, new ListNode(-1, L1));
        ListNode<Integer> L3 = new ListNode<>(-2, L1);

        ListNode.printList(L2);
        ListNode.printList(L3);

        ListNode<Integer> L0 = overlapping(L2, L3);
        ListNode.printList(L0);
    }
}
