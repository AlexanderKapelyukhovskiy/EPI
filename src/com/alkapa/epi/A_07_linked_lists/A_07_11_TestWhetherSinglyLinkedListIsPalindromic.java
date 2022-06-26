package com.alkapa.epi.A_07_linked_lists;

public class A_07_11_TestWhetherSinglyLinkedListIsPalindromic {
    public static boolean isPalindromic(ListNode<Integer> L) {
        ListNode<Integer> fast = L;
        ListNode<Integer> slow = L;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode<Integer> firstHalf = L;
        ListNode<Integer> secondHalf = ListNode.reverseList(slow);

        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    public static void main (String[] args) {
        ListNode<Integer> listNode = ListNode.createTestList(5);
        ListNode.printList(listNode);
        ListNode<Integer> reversed = ListNode.reverseList(ListNode.createTestList(5));
        ListNode.printList(reversed);
        ListNode<Integer> palindrome = ListNode.concat(listNode, reversed);
        ListNode.printList(palindrome);
        System.out.println(isPalindromic(palindrome));
    }
}
