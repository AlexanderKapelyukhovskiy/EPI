package com.alkapa.epi.A_07_linked_lists;

public class A_07_13_AddListBasedIntegers {
    public static ListNode<Integer> addTwoNumbers(ListNode<Integer> L1, ListNode<Integer> L2) {
        ListNode<Integer> head = new ListNode<Integer>(0);
        ListNode<Integer> sum =  head;
        while (L1 != null && L2 != null) {
            sum.data = sum.data + L1.data + L2.data;
            if (sum.data > 9) {
                sum.next = new ListNode<Integer>(sum.data /10);
                sum.data %= 10;
            } else {
                sum.next = new ListNode<Integer>(0);
            }
            sum = sum.next;
            L1 = L1.next;
            L2 = L2.next;
        }
        
        return head;
    }

    public static void main(String[] args) {
        ListNode<Integer> l1 = ListNode.createTestList(3);
        ListNode<Integer> l2 = ListNode.createTestList(3);

        ListNode<Integer> sum = addTwoNumbers(l1, l2);
        ListNode.printList(sum);
    }
}
