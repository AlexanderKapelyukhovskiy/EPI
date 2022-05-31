package com.alkapa.epi.linked_lists;

public class A_07_12_ImplementListPivoting {
    public static ListNode<Integer> listPivoting(ListNode<Integer> L, int k) {
        ListNode<Integer> lessHead = new ListNode<>();
        ListNode<Integer> equalHead = new ListNode<>();
        ListNode<Integer> greaterHead = new ListNode<>();

        ListNode<Integer> lessIter = lessHead;
        ListNode<Integer> equalIter = equalHead;
        ListNode<Integer> greaterIter = greaterHead;

        ListNode<Integer> iter = L;
        while (iter != null) {
            if (iter.data < k) {
                lessIter.next = iter;
                lessIter = iter;
            } else if (iter.data == k) {
                equalIter.next = iter;
                equalIter = iter;
            } else { //iter.data > k
                greaterIter.next = iter;
                greaterIter = iter;
            }
            iter = iter.next;
        }

        greaterIter.next = null;
        lessIter.next = equalHead.next;
        equalIter.next = greaterHead.next;

        return lessHead.next;
    }

    public static void main (String[] args)
    {
        ListNode<Integer> list1 = ListNode.createTestList(10);
        ListNode<Integer> list2 = ListNode.createTestList(10);
        ListNode<Integer> list = ListNode.concat(list1, list2);
        ListNode<Integer> resultNode = listPivoting(list, 5);
        ListNode.printList(resultNode);
    }
}
