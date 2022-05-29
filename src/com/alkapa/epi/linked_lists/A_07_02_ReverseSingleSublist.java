package com.alkapa.epi.linked_lists;

import java.util.LinkedList;

public class A_07_02_ReverseSingleSublist {
    public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish) {
        ListNode<Integer> head = L;
        ListNode<Integer> prev = null;
        ListNode<Integer> t = null;
        ListNode<Integer> next;
        for (int i = 0; i <= finish + 1 && L != null; ++i) {
            if (i == start - 1) {
                prev = L;
                t = L.next;
            }
            if (i <= start) {
                L = L.next;
                if (i == start) {
                    t.next = null;
                }
            } else  if (i > start && i <= finish) {
                next = L.next;
                L.next  = t;
                t = L;
                L = next;
                prev.next = t;
            } else {
                next = t;
                while (next.next != null) {
                    next = next.next;
                }
                next.next = L;

                break;
            }
        }
        return head;
    }

    public static ListNode<Integer> reverseSublistV2(ListNode<Integer> L, int start, int finish) {
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> sublistHead = dummyHead;
        int k = 0;
        while (k++ < start) {
            sublistHead = sublistHead.next;
        }

        ListNode sublistIterator = sublistHead.next;
        while(start++ < finish) {
            ListNode<Integer> temp = sublistIterator.next;
            sublistIterator.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;
        }
        return dummyHead.next;
    }

    public static ListNode<Integer> reverseSublistV3(ListNode<Integer> L, int start, int finish) {
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> sublistHead = dummyHead;

        int k = 0;
        while (k++ < start) {
            sublistHead = sublistHead.next;
        }

        ListNode<Integer> sublistIterator = sublistHead.next;

        while (start++ < finish) {//we do not change sublistIterator link (only its next) - it is tail
            ListNode<Integer> t = sublistIterator.next;//get next
            sublistIterator.next = t.next;//set next for tail  as one ofter next
            t.next = sublistHead.next;//set current next to sublist header next
            sublistHead.next = t;//set sublist header next to newly reverted node
        }
        return dummyHead.next;
    }


    public static void test(ListNode<Integer> L, int start, int finish) {
        ListNode.printList(L);
        ListNode res = reverseSublistV3(L, start, finish);
        ListNode.printList(res);
        System.out.println();
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
    public static void main(String[] arg) {
        test(createL1(), 1, 3);
    }
}
