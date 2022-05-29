package com.alkapa.epi.linked_lists;

import java.util.LinkedList;

public class A_07_01_MergeTwoSortedLists {
    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> L1, ListNode<Integer> L2) {
        ListNode<Integer> T = null;
        ListNode<Integer> R = null;
        while (L1 != null || L2 != null) {
            if (T == null) {
                if (L1 == null) {
                    R = L2;
                    break;
                }
                if (L2 == null) {
                    R = L1;
                    break;
                } else {
                    if (L1.data < L2.data) {
                        R = T = L1;
                        L1 = L1.next;
                    } else {
                        R = T = L2;
                        L2 = L2.next;
                    }
                }
            } else {
                if (L1 == null) {
                    T.next = L2;
                    break;
                }
                if (L2 == null) {
                    T.next = L1;
                    break;
                } else {
                    if (L1.data < L2.data) {
                        T.next = L1;
                        L1 = L1.next;
                    } else {
                        T.next = L2;
                        L2 = L2.next;
                    }
                }
                T = T.next;
            }
        }
        return R;
    }

    public static ListNode<Integer> mergeTwoSortedListsV2(ListNode<Integer> L1, ListNode<Integer> L2) {
        ListNode<Integer> dummyHead = new ListNode<>();
        ListNode<Integer> current = dummyHead;

        while (L1 != null && L2 != null) {
            if(L1.data < L2.data) {
                current.next = L1;
                L1 = L1.next;
            } else {
                current.next = L2;
                L2 = L2.next;
            }
            current = current.next;
        }

        current.next = L1 != null ? L1 : L2;

        return dummyHead.next;

    }

    public static void test(ListNode<Integer> L1, ListNode<Integer> L2) {
        printList(L1);
        printList(L2);
        ListNode<Integer> R = mergeTwoSortedListsV2(L1, L2);
        System.out.print("Result: ");
        printList(R);
        System.out.println("--------------");
    }

    public static void printList(ListNode<Integer> L) {
        if (L == null) {
            System.out.println("Empty List");
            return;
        }

        while (L != null) {
            System.out.print(L.data + ", ");
            L = L.next;
        }
        System.out.println();
    }

    public static ListNode<Integer> createL1() {
        ListNode<Integer> L1 = new ListNode<>();
        L1.data = 1;
        L1.next = new ListNode<>();
        L1.next.data = 3;
        L1.next.next = new ListNode<>();
        L1.next.next.data = 5;
        return L1;
    }

    public static ListNode<Integer> createL2() {
        ListNode<Integer> L2 = new ListNode<>();
        L2.data = 2;
        L2.next = new ListNode<>();
        L2.next.data = 4;
        return L2;
    }

    public static void main(String[] args) {
        test(createL1(), createL2());
        test(createL2(), createL1());

        test(createL1(), createL1());
        test(createL2(), createL2());

        test(createL1(), null);
        test(null, createL2());

        test(null, null);
    }
}
